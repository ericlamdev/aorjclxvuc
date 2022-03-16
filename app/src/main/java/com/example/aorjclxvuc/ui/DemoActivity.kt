package com.example.aorjclxvuc.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.commit
import com.example.aorjclxvuc.R
import com.example.aorjclxvuc.databinding.ActivityDemoBinding
import com.example.aorjclxvuc.utils.launchAndCollectIn
import com.example.aorjclxvuc.utils.onSingleClick
import com.example.aorjclxvuc.viewmodel.DemoViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DemoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDemoBinding

    private val viewModel: DemoViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_demo)

        binding.lifecycleOwner = this
        binding.apply {
            vm = viewModel

            btnLoadData.onSingleClick {
                viewModel.getCurrencyInfoList()
            }

            btnSort.onSingleClick {
                viewModel.getCurrencyInfoList(
                    viewModel.isSortByAscFlow.value?.not() ?: true
                )
            }
        }

        observe()
    }

    private fun observe() {
        viewModel.currencyInfoListFlow.launchAndCollectIn(this) { list ->
            binding.tvEmpty.isVisible = list?.isEmpty() ?: true

            list?.let {
                with(supportFragmentManager) {
                    viewModel.isSortByAscFlow.value?.let {
                        (findFragmentByTag(CurrencyListFragment::class.java.simpleName) as? CurrencyListFragment)?.updateList(
                            ArrayList(list)
                        )
                    } ?: commit {
                        replace(
                            binding.fcContainer.id,
                            CurrencyListFragment.create(
                                CurrencyListBundle(ArrayList(it))
                            )
                        )
                        addToBackStack(CurrencyListFragment::class.java.simpleName)
                    }
                }
            }
        }
    }
}
