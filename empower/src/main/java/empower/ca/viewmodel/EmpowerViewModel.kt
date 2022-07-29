package empower.ca.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import empower.ca.dto.ContentDto
import empower.ca.dto.ContentWrapperDto
import empower.ca.dto.OperatorDto
import empower.ca.model.EmpowerHttp
import empower.ca.repository.EmpowerRepository
import empower.ca.sealed.Power
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class EmpowerViewModel(
    private val repository: EmpowerRepository
) : ViewModel() {

    private val _content = MutableLiveData<List<ContentDto>>()
    val content: LiveData<List<ContentDto>>
        get() = _content

    private val _state = MutableLiveData<State>()
    val state: LiveData<State>
        get() = _state

    fun listContent(power: Power?) {
        viewModelScope.launch {
            withContext(Dispatchers.Main) {
                when (power) {
                    is Power.Banner -> {
                        _content.value = (
                            listOf(
                                ContentDto(
                                    "Iron Man",
                                    "test title",
                                    "test description",
                                    "https://cdn.britannica.com/49/182849-050-4C7FE34F/scene-Iron-Man.jpg",
                                    listOf(
                                        OperatorDto(
                                            "button",
                                            "open detail",
                                            "detail screen",
                                            "learn more"
                                        )
                                    )
                                ),
                                ContentDto(
                                    "Iron Man",
                                    "test title",
                                    "test description",
                                    "https://cdn.britannica.com/49/182849-050-4C7FE34F/scene-Iron-Man.jpg",
                                    listOf(
                                        OperatorDto(
                                            "link",
                                            "open detail",
                                            "detail screen",
                                            "learn more"
                                        )
                                    )
                                ),
                                ContentDto(
                                    "Iron Man",
                                    "test title",
                                    "test description",
                                    "https://cdn.britannica.com/49/182849-050-4C7FE34F/scene-Iron-Man.jpg",
                                    listOf(
                                        OperatorDto(
                                            "link",
                                            "open detail",
                                            "detail screen",
                                            "go there"
                                        )
                                    )
                                ),
                                ContentDto(
                                    "Iron Man",
                                    "test title",
                                    "test description",
                                    "https://cdn.britannica.com/49/182849-050-4C7FE34F/scene-Iron-Man.jpg",
                                    listOf(
                                        OperatorDto(
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
                                ContentDto(
                                    "Iron Man",
                                    "test title",
                                    "test description",
                                    "https://cdn.britannica.com/49/182849-050-4C7FE34F/scene-Iron-Man.jpg",
                                    listOf(
                                        OperatorDto(
                                            "button",
                                            "open detail",
                                            "detail screen",
                                            "learn more"
                                        )
                                    )
                                ),
                                ContentDto(
                                    "Iron Man",
                                    "test title",
                                    "test description",
                                    "https://cdn.britannica.com/49/182849-050-4C7FE34F/scene-Iron-Man.jpg",
                                    listOf(
                                        OperatorDto(
                                            "link",
                                            "open detail",
                                            "detail screen",
                                            "learn more"
                                        )
                                    )
                                ),
                                ContentDto(
                                    "Iron Man",
                                    "test title",
                                    "test description",
                                    "https://cdn.britannica.com/49/182849-050-4C7FE34F/scene-Iron-Man.jpg",
                                    listOf(
                                        OperatorDto(
                                            "button",
                                            "open detail",
                                            "detail screen",
                                            "learn more"
                                        ),
                                        OperatorDto(
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
                                ContentDto(
                                    "Iron Man",
                                    "test title",
                                    "test description",
                                    "https://cdn.britannica.com/49/182849-050-4C7FE34F/scene-Iron-Man.jpg",
                                    listOf(
                                        OperatorDto(
                                            "button",
                                            "open detail",
                                            "detail screen",
                                            "learn more"
                                        )
                                    )
                                ),
                                ContentDto(
                                    "Iron Man",
                                    "test title",
                                    "test description",
                                    "https://cdn.britannica.com/49/182849-050-4C7FE34F/scene-Iron-Man.jpg",
                                    listOf(
                                        OperatorDto(
                                            "link",
                                            "open detail",
                                            "detail screen",
                                            "learn more"
                                        )
                                    )
                                ),
                                ContentDto(
                                    "Iron Man",
                                    "test title",
                                    "test description",
                                    "https://cdn.britannica.com/49/182849-050-4C7FE34F/scene-Iron-Man.jpg",
                                    listOf(
                                        OperatorDto(
                                            "button",
                                            "open detail",
                                            "detail screen",
                                            "learn more"
                                        ),
                                        OperatorDto(
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
                                ContentDto(
                                    "Iron Man",
                                    "test title",
                                    "test description",
                                    "https://cdn.britannica.com/49/182849-050-4C7FE34F/scene-Iron-Man.jpg",
                                    listOf(
                                        OperatorDto(
                                            "button",
                                            "open detail",
                                            "detail screen",
                                            "learn more"
                                        )
                                    )
                                ),
                                ContentDto(
                                    "Iron Man",
                                    "test title",
                                    "test description",
                                    "https://cdn.britannica.com/49/182849-050-4C7FE34F/scene-Iron-Man.jpg",
                                    listOf(
                                        OperatorDto(
                                            "link",
                                            "open detail",
                                            "detail screen",
                                            "learn more"
                                        )
                                    )
                                ),
                                ContentDto(
                                    "Iron Man",
                                    "test title",
                                    "test description",
                                    "https://cdn.britannica.com/49/182849-050-4C7FE34F/scene-Iron-Man.jpg",
                                    listOf(
                                        OperatorDto(
                                            "button",
                                            "open detail",
                                            "detail screen",
                                            "learn more"
                                        ),
                                        OperatorDto(
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
                    else -> {
                        _content.value = (
                                listOf(
                                    ContentDto(
                                        "Iron Man",
                                        "test title",
                                        "test description",
                                        "https://cdn.britannica.com/49/182849-050-4C7FE34F/scene-Iron-Man.jpg",
                                        listOf(
                                            OperatorDto(
                                                "button",
                                                "open detail",
                                                "detail screen",
                                                "learn more"
                                            )
                                        )
                                    ),
                                    ContentDto(
                                        "Iron Man",
                                        "test title",
                                        "test description",
                                        "https://cdn.britannica.com/49/182849-050-4C7FE34F/scene-Iron-Man.jpg",
                                        listOf(
                                            OperatorDto(
                                                "link",
                                                "open detail",
                                                "detail screen",
                                                "learn more"
                                            )
                                        )
                                    ),
                                    ContentDto(
                                        "Iron Man",
                                        "test title",
                                        "test description",
                                        "https://cdn.britannica.com/49/182849-050-4C7FE34F/scene-Iron-Man.jpg",
                                        listOf(
                                            OperatorDto(
                                                "button",
                                                "open detail",
                                                "detail screen",
                                                "learn more"
                                            ),
                                            OperatorDto(
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

    fun getJson(url: String){
        viewModelScope.launch {
            _state.value = State.Loading

            val result = withContext(Dispatchers.IO) {
                EmpowerHttp.getJson(url)
            }

            if(result == null){
                _state.value = State.Error(Exception("Error loading content"), false)
            }else{
                _state.value = State.Loaded(result)
            }
        }
    }

    fun setContentWrapperState(contentWrapper: ContentWrapperDto) {
        viewModelScope.launch {
            _state.value = State.Loading

            _state.value = State.Loaded(contentWrapper)
        }
    }

    sealed class State {
        object Loading: State()
        data class Loaded(val contentWrapperDto: ContentWrapperDto?): State()
        data class Error(val e: Throwable, var hasConsumed: Boolean): State()
    }
}
