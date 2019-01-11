package com.greenleaf.katalogmovie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.greenleaf.katalogmovie.apiservice.BaseApiService;
import com.greenleaf.katalogmovie.apiservice.UtilsApi;
import com.greenleaf.katalogmovie.model.ResultsItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.pb_loading)
    ProgressBar pbloading;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerview;
    @BindView(R.id.edt_title)
    EditText edttitle;
    @BindView(R.id.btn_cari)
    Button btnsearch;
//    @BindView(R.id.search_bar)
//    SearchView search;

    BaseApiService mApiService;
    MovieAdapter mRepoAdapter;

    List<ResultsItem> repoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mApiService = UtilsApi.getAPIService();

        mRepoAdapter = new MovieAdapter(this, repoList, null);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        recyclerview.setHasFixedSize(true);
        recyclerview.setAdapter(mRepoAdapter);

        btnsearch.setOnClickListener(myListener);


//        edttitle.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                if (actionId == EditorInfo.IME_ACTION_SEARCH){
//                    String title = edttitle.getText().toString();
//                    requestRepos(title);
//                    return true;
//                }
//                return false;
//            }
//        });

    }
    View.OnClickListener myListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String title = edttitle.getText().toString();
            requestRepos(title);
        }
    };


    private void requestRepos(String title){
        pbloading.setVisibility(View.VISIBLE);

        mApiService.requestRepos(title)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new io.reactivex.Observer<List<ResultsItem>>(){
                    @Override
                    public void onSubscribe(Disposable d){

                    }

                    @Override
                    public void onNext(List<ResultsItem> responseRepos){
                        for (int i = 0; i < responseRepos.size(); i++){
                            String title = responseRepos.get(i).getTitle();
                            String description = responseRepos.get(i).getOverview();
                            String date = responseRepos.get(i).getReleaseDate();

                            repoList.add(new ResultsItem(title, description, date));
                        }
                    }

                    @Override
                    public void onError(Throwable e){
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete(){
                        pbloading.setVisibility(View.GONE);
                        Toast.makeText(MainActivity.this, "Berhasil Mengambil Data", Toast.LENGTH_SHORT).show();

                        mRepoAdapter = new MovieAdapter(MainActivity.this, repoList, null);
                        recyclerview.setAdapter(mRepoAdapter);
                        mRepoAdapter.notifyDataSetChanged();
                    }
                });
    }


}
