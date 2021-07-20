package com.example.chunggo803


import com.example.chunggo803.databinding.FragmentMypageBinding
import org.koin.android.viewmodel.ext.android.viewModel

class MyPageFragment : BaseFragment<MyPageViewModel, FragmentMypageBinding>() {
    override val viewModel by viewModel<MyPageViewModel>()
    override fun getViewBinding(): FragmentMypageBinding = FragmentMypageBinding.inflate(layoutInflater)

    override fun observeData() {

    }
    companion object {
        fun newInstance() = MyPageFragment()
        const val TAG = "MyPageFragment"
    }
}