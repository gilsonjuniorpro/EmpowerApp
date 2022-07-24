package empower.ca.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingConfig
import empower.ca.enums.ContentType
import empower.ca.model.Content
import empower.ca.model.Operator
import empower.ca.sealed.Power
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ContentViewModel : ViewModel() {

    private val _content = MutableLiveData<List<Content>>()
    val content: LiveData<List<Content>>
        get() = _content

    fun listContent(power: Power) {
        viewModelScope.launch {
            withContext(Dispatchers.Main) {
                when (power) {
                    is Power.Banner -> {
                        _content.value = (
                            listOf(
                                Content(
                                    "Iron Man",
                                    "test title",
                                    "test description",
                                    "https://cdn.britannica.com/49/182849-050-4C7FE34F/scene-Iron-Man.jpg",
                                    listOf(
                                        Operator(
                                            "button",
                                            "open detail",
                                            "detail screen",
                                            "learn more"
                                        )
                                    )
                                ),
                                Content(
                                    "Iron Man",
                                    "test title",
                                    "test description",
                                    "https://cdn.britannica.com/49/182849-050-4C7FE34F/scene-Iron-Man.jpg",
                                    listOf(
                                        Operator(
                                            "link",
                                            "open detail",
                                            "detail screen",
                                            "learn more"
                                        )
                                    )
                                ),
                                Content(
                                    "Iron Man",
                                    "test title",
                                    "test description",
                                    "https://cdn.britannica.com/49/182849-050-4C7FE34F/scene-Iron-Man.jpg",
                                    listOf(
                                        Operator(
                                            "link",
                                            "open detail",
                                            "detail screen",
                                            "go there"
                                        )
                                    )
                                ),
                                Content(
                                    "Iron Man",
                                    "test title",
                                    "test description",
                                    "https://cdn.britannica.com/49/182849-050-4C7FE34F/scene-Iron-Man.jpg",
                                    listOf(
                                        Operator(
                                            "button",
                                            "open detail",
                                            "detail screen",
                                            "learn more"
                                        )
                                    )
                                )
                            )
                        )
                    }
                    is Power.Basic -> {
                        _content.value = (
                            listOf(
                                Content(
                                    "Iron Man",
                                    "test title",
                                    "test description",
                                    "https://cdn.britannica.com/49/182849-050-4C7FE34F/scene-Iron-Man.jpg",
                                    listOf(
                                        Operator(
                                            "button",
                                            "open detail",
                                            "detail screen",
                                            "learn more"
                                        )
                                    )
                                ),
                                Content(
                                    "Iron Man",
                                    "test title",
                                    "test description",
                                    "https://cdn.britannica.com/49/182849-050-4C7FE34F/scene-Iron-Man.jpg",
                                    listOf(
                                        Operator(
                                            "link",
                                            "open detail",
                                            "detail screen",
                                            "learn more"
                                        )
                                    )
                                ),
                                Content(
                                    "Iron Man",
                                    "test title",
                                    "test description",
                                    "https://cdn.britannica.com/49/182849-050-4C7FE34F/scene-Iron-Man.jpg",
                                    listOf(
                                        Operator(
                                            "button",
                                            "open detail",
                                            "detail screen",
                                            "learn more"
                                        ),
                                        Operator(
                                            "link",
                                            "open detail",
                                            "detail screen",
                                            "go there"
                                        )
                                    )
                                )
                            )
                        )
                    }
                    is Power.Expose -> {
                        _content.value = (
                            listOf(
                                Content(
                                    "Iron Man",
                                    "test title",
                                    "test description",
                                    "https://cdn.britannica.com/49/182849-050-4C7FE34F/scene-Iron-Man.jpg",
                                    listOf(
                                        Operator(
                                            "button",
                                            "open detail",
                                            "detail screen",
                                            "learn more"
                                        )
                                    )
                                ),
                                Content(
                                    "Iron Man",
                                    "test title",
                                    "test description",
                                    "https://cdn.britannica.com/49/182849-050-4C7FE34F/scene-Iron-Man.jpg",
                                    listOf(
                                        Operator(
                                            "link",
                                            "open detail",
                                            "detail screen",
                                            "learn more"
                                        )
                                    )
                                ),
                                Content(
                                    "Iron Man",
                                    "test title",
                                    "test description",
                                    "https://cdn.britannica.com/49/182849-050-4C7FE34F/scene-Iron-Man.jpg",
                                    listOf(
                                        Operator(
                                            "button",
                                            "open detail",
                                            "detail screen",
                                            "learn more"
                                        ),
                                        Operator(
                                            "link",
                                            "open detail",
                                            "detail screen",
                                            "go there"
                                        )
                                    )
                                )
                            )
                        )
                    }
                    is Power.Ads -> {
                        _content.value = (
                            listOf(
                                Content(
                                    "Iron Man",
                                    "test title",
                                    "test description",
                                    "https://cdn.britannica.com/49/182849-050-4C7FE34F/scene-Iron-Man.jpg",
                                    listOf(
                                        Operator(
                                            "button",
                                            "open detail",
                                            "detail screen",
                                            "learn more"
                                        )
                                    )
                                ),
                                Content(
                                    "Iron Man",
                                    "test title",
                                    "test description",
                                    "https://cdn.britannica.com/49/182849-050-4C7FE34F/scene-Iron-Man.jpg",
                                    listOf(
                                        Operator(
                                            "link",
                                            "open detail",
                                            "detail screen",
                                            "learn more"
                                        )
                                    )
                                ),
                                Content(
                                    "Iron Man",
                                    "test title",
                                    "test description",
                                    "https://cdn.britannica.com/49/182849-050-4C7FE34F/scene-Iron-Man.jpg",
                                    listOf(
                                        Operator(
                                            "button",
                                            "open detail",
                                            "detail screen",
                                            "learn more"
                                        ),
                                        Operator(
                                            "link",
                                            "open detail",
                                            "detail screen",
                                            "go there"
                                        )
                                    )
                                )
                            )
                        )
                    }
                }
            }
        }
    }
}
