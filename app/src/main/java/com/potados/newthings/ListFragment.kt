package com.potados.newthings

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.potados.newthings.databinding.ListFragmentBinding


class ListFragment : Fragment() {

    private lateinit var viewModel: ListViewModel
    private lateinit var viewDataBinding: ListFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = ListFragmentBinding.inflate(inflater, container, false).apply {
            viewModel = this@ListFragment.viewModel
        }

        return viewDataBinding.root
    }

    /**
     * All views in their places.
     */
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner
        setupAdapter()
        viewModel.refreshDummies()
    }


    private fun setupAdapter() {
        with (viewDataBinding) {
            listRecyclerview.adapter = ListRecyclerViewAdapter()
        }
    }
}
