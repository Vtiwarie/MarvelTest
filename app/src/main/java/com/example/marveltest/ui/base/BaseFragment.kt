package com.example.irokutest.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import javax.inject.Inject

abstract class BaseFragment<P : BasePresenter<V>, V : BaseView> : Fragment() {

    @Inject
    protected lateinit var presenter: P

    abstract val layoutID: Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(layoutID, container, false)

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this as V, lifecycle)

        setUpViews()
        setUpListeners()
    }

    protected open fun setUpViews() {}
    protected open fun setUpListeners() {}
}

