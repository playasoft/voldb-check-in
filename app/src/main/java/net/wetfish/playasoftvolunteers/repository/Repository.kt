package net.wetfish.playasoftvolunteers.repository

/**
 * Created by  on 9/27/2019.
// */
//object RetrofitRepository : Repository {
//
//    private val TAG = RetrofitRepository::class.qualifiedName
//
//    private const val LOGIN = "Luminesce0"
//
//    override fun getRepos(): LiveData<List<Repo>> {
//        val liveData = MutableLiveData<List<Repo>>()
//
//        FetchreposAsynTask({ repos ->
//            liveData.value = repos
//        }).execute()
//
//        return liveData
//    }
//
//    override fun getGists(): LiveData<List<Gist>> {
//        val liveData = MutableLiveData<List<Gist>>()
//        val gists = mutableListOf<Gist>()
//
//        for (i in 0 until 100) {
//            val gist = Gist("2018-02-23T17:42:52Z", "w00t")
//            gists.add(gist)
//        }
//
//        liveData.value = gists
//
//        return liveData
//    }
//
//    override fun getUser(): LiveData<User> {
//        val liveData = MutableLiveData<User>()
//
//        val user = User(
//            1234L,
//            "w00tze",
//            "w00tze",
//            "W00tzeWootze",
//            "https://avatars0.githubusercontent.com/u/36771440?v=4")
//
//        liveData.value = user
//
//        return liveData
//    }
//
//    private fun fetchRepos(): List<Repo>? {
//        try {
//            val url = Uri.parse(fullUrlString("/users/$LOGIN/repose")).toString()
//            val jsonString = getUrlAsString(url)
//
//            Log.i(TAG, "Repo data: $jsonString")
//
//            val repos = mutableListOf<Repo>()
//
//            for (i in 0 until 100) {
//                val repo = Repo("repo departmentName")
//                repos.add(repo)
//            }
//
//            return repos
//        } catch (e: IOException) {
//            Log.e(TAG, "Error retrieving repos: ${e.localizedMessage}")
//        }
//        return null
//    }
//
//    private class FetchreposAsynTask(val callback: ReposeCallback) : AsyncTask<ReposeCallback, Void, List<Repo>>() {
//        override fun doInBackground(vararg params: ReposeCallback?): List<Repo>? {
//            return fetchRepos()
//        }
//
//        override fun onPostExecute(result: List<Repo>?) {
//            super.onPostExecute(result)
//            if (result != null) {
//                callback(result)
//            }
//        }
//    }
//}