package jp.cordea.reiz

import android.content.Context
import android.widget.AdapterView
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable

class AddSessionMenuViewModel(override val context: Context) : IViewModel {

    val adapter = AddSessionMenuListAdapter(context)

    val onItemClickListener = AdapterView.OnItemClickListener { _, _, i, _ ->
        adapter.getItem(i).incCount()
    }

    private var disposable: Disposable? = null

    init {
        disposable = MenuRepository.getMenus()
                .toObservable()
                .flatMap { Observable.fromIterable(it) }
                .map { AddSessionMenuListItemViewModel(it) }
                .toList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    adapter.setItems(it)
                }, {
                })
    }

    override fun dispose() {
        disposable?.dispose()
    }
}