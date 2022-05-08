package com.github.yuto5176.gummyviewer.ui.screens.home

import androidx.lifecycle.ViewModel
import com.github.yuto5176.gummyviewer.domain.repository.GummyInfoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val gummyInfoRepository: GummyInfoRepository,
) : ViewModel() {

    private val _tagList = MutableStateFlow<List<String>>(listOf("tag1", "tag2", "tag3"))
    val tagList: StateFlow<List<String>> = _tagList.asStateFlow()

    private val _selectedTag = MutableStateFlow<String>("")
    val tagSelected: StateFlow<String> = _selectedTag.asStateFlow()

    fun setTagSelected(tagName: String){
        _selectedTag.value = tagName
    }
}