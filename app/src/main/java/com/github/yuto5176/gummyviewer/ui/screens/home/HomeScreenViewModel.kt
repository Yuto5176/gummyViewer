package com.github.yuto5176.gummyviewer.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.yuto5176.gummyviewer.data.model.GummyDetail
import com.github.yuto5176.gummyviewer.domain.repository.GummyInfoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val gummyInfoRepository: GummyInfoRepository,
) : ViewModel() {

    private val _tagList = MutableStateFlow<List<String>>(listOf("tag1", "tag2", "tag3"))
    val tagList: StateFlow<List<String>> = _tagList.asStateFlow()

    private val _gummyCards = MutableStateFlow<List<GummyDetail>>(emptyList())
    val gummyCards: StateFlow<List<GummyDetail>> get() = _gummyCards.asStateFlow()

    private fun fetchData() {
        viewModelScope.launch(Dispatchers.IO) {
            gummyInfoRepository.fetchData(5).collectLatest {
                _gummyCards.value = it
            }
        }
    }

    init {
        fetchData()
    }
}