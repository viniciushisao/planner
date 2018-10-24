package br.com.hisao.planner.viewmodel;

import android.app.Application;
import android.app.DownloadManager;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import br.com.hisao.planner.model.City;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;

import static com.android.volley.Request.Method.GET;


public class MainActivityViewModel extends AndroidViewModel {
    RequestQueue queue = Volley.newRequestQueue(getApplication().getApplicationContext());

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }


    public Single<List<City>> getCities() {
        return Single.create(new SingleOnSubscribe<List<City>>() {
            @Override
            public void subscribe(@NonNull final SingleEmitter<List<City>> e) throws Exception {
                JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(GET, "localhost:8882/cities/", null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                if (response != null) {
                                    ArrayList<City> result = new ArrayList<>();
//
//                                    try {
//                                        for (int i = 0; i < response.length(); i++) {
//                                            result.add(getCities(response.getJSONObject(i)));
//                                        }
//                                    } catch (JSONException ex) {
//                                        e.onError(ex);
//                                    }

                                    e.onSuccess(result);
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                e.onError(error);
                            }
                        }
                );
                queue.add(jsonObjectRequest);

//                VolleyDispatcher.getInstance().addToQueue(jsonObjectRequest);
            }
        });
    }
}
