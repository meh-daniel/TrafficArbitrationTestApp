package traffic.arbitration.test.app.ru.presentation.screens.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(): ViewModel() {

    private val _action: Channel<SplashAction> = Channel(Channel.BUFFERED)
    var actionFlow = _action.receiveAsFlow()

    init {
        startLogic()
    }

    private fun startLogic() {
        viewModelScope.launch(Dispatchers.IO) {
            delay(3000)
            sendAction(SplashAction.NavigateToMain)
        }
    }

    private fun sendAction(action: SplashAction){
        viewModelScope.launch(Dispatchers.Main){
            _action.send(action)
        }
    }

}