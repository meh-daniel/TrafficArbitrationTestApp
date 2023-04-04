package traffic.arbitration.test.app.ru.presentation.screens.splash

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import traffic.arbitration.test.app.ru.R
import traffic.arbitration.test.app.ru.databinding.FragmentSplashBinding
import traffic.arbitration.test.app.ru.utils.observeInLifecycle

@AndroidEntryPoint
class SplashFragment: Fragment() {

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SplashViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSubscriberAction()
        startAppsFlyer()
    }

    private fun setupSubscriberAction() {
        viewModel.actionFlow.onEach { action ->
            when(action) {
                is SplashAction.NavigateToMain -> {
                    findNavController().navigate(R.id.action_splashFragment_to_mainFragment)
                }
            }
        }.observeInLifecycle(viewLifecycleOwner)
    }

    private fun startAppsFlyer() {
        val conversionDataListener = object : AppsFlyerConversionListener {
            override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
                val status = data?.get("af_status").toString()
                if (status.contains("Organic")) {
                    data?.forEach{
                        viewModel.utmKeys[it.key] = it.value.toString()
                        Log.d("xxx123", "${it.key} ${it.value.toString()}")
                    }
                }
                viewModel.sendLocalData()
            }
            override fun onConversionDataFail(error: String?) {}
            override fun onAppOpenAttribution(data: MutableMap<String, String>?) {}
            override fun onAttributionFailure(error: String?) {}
        }
        CoroutineScope(Dispatchers.IO).launch {    AppsFlyerLib.getInstance()
            .init("9VGjSHvoEozBcKB5puD937", conversionDataListener, this@SplashFragment.requireActivity().applicationContext)
            AppsFlyerLib.getInstance().start(this@SplashFragment.requireActivity())
        }
    }
}