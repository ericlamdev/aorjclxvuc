package com.example.aorjclxvuc.ui

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.aorjclxvuc.R
import com.example.aorjclxvuc.adapter.CurrencyListAdapter
import com.example.aorjclxvuc.databinding.FragmentCurrencyListBinding
import com.example.aorjclxvuc.model.CurrencyInfo
import kotlinx.parcelize.Parcelize

@Parcelize
data class CurrencyListBundle(
    val currencyInfoList: ArrayList<CurrencyInfo>
) : Parcelable

class CurrencyListFragment : Fragment() {

    companion object {

        private const val BUNDLE_KEY_CURRENCY_LIST = "currency_info_list"

        fun create(bundle: CurrencyListBundle): CurrencyListFragment =
            CurrencyListFragment().apply {
                arguments = bundleOf(
                    BUNDLE_KEY_CURRENCY_LIST to bundle
                )
            }
    }

    private var binding: FragmentCurrencyListBinding? = null

    private val currencyListAdapter: CurrencyListAdapter by lazy {
        CurrencyListAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_currency_list, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            rvCurrencyInfoList.adapter = currencyListAdapter

            (arguments?.get(BUNDLE_KEY_CURRENCY_LIST) as? CurrencyListBundle)?.let {
                currencyListAdapter.submitList(it.currencyInfoList)
            }
        }
    }

    fun updateList(currencyInfoList: ArrayList<CurrencyInfo>) {
        currencyListAdapter.submitList(currencyInfoList)
    }
}
