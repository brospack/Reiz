package jp.cordea.reiz

import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import jp.cordea.reiz.model.Record
import java.util.*

object RecordRepository {

    private val recordDao = ReizApplication.Database.recordDao()

    fun getPastRecords(): Single<List<Record>> =
            Single
                    .fromCallable {
                        recordDao.getPastRecords()
                    }
                    .subscribeOn(Schedulers.io())

    fun getCurrentRecord(): Single<Optional<Record>> =
            Single
                    .fromCallable {
                        Optional.ofNullable(recordDao.getCurrentRecord())
                    }
                    .subscribeOn(Schedulers.io())

    fun addRecord(record: Record): Completable =
            Completable
                    .fromCallable {
                        recordDao.insertRecord(record)
                    }
                    .subscribeOn(Schedulers.io())

    fun updateRecord(record: Record): Completable =
            Completable
                    .fromCallable {
                        recordDao.updateRecord(record)
                    }
                    .subscribeOn(Schedulers.io())
}
