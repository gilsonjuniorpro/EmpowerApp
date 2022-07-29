package empower.ca.repository

import android.content.Context

class EmpowerRepository(context: Context) {

    private val operatorDao =
        AppDatabase.getDatabase(
            context
        ).getOperatorDao()

    private val containerDao =
        AppDatabase.getDatabase(
            context
        ).getContainerDao()

    private val contentDao =
        AppDatabase.getDatabase(
            context
        ).getContentDao()


}
