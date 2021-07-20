package com.example.chunggo803

import com.example.chunggo803.databinding.FragmentChatlistBinding
import org.koin.android.viewmodel.ext.android.viewModel

class ChatListFragment  : BaseFragment<ChatListViewModel, FragmentChatlistBinding>() {
    override val viewModel by viewModel<ChatListViewModel>()
    override fun getViewBinding(): FragmentChatlistBinding = FragmentChatlistBinding.inflate(layoutInflater)

    override fun observeData() {

    }
    companion object {
        fun newInstance() = ChatListFragment()
        const val TAG = "ChatListFragment"
    }
}