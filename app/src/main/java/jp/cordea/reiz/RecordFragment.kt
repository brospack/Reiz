package jp.cordea.reiz

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import jp.cordea.reiz.databinding.FragmentRecordBinding

class RecordFragment : Fragment() {

    private lateinit var binding: FragmentRecordBinding

    private val presenter by lazy {
        RecordPresenter(this, binding)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View =
            FragmentRecordBinding.inflate(inflater, container, false).also {
                binding = it
            }.root

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter.onCreate()
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

    companion object {

        fun newInstance(): RecordFragment {
            return RecordFragment()
        }
    }
}
