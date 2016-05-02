package com.example.sestens.pocket_advisor;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.content.Intent;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

/**
 * Created by sestens on 4/29/2016.
 *Algorithm:
 * 1.- Send a request to get_grades.php in the AWS server using Background Async task
 * 2.-Parse the JSON and display in a listview
 * 3.-If there are no grades addnewgrades procedure is launched
 */

public class GradesActivity extends ListActivity{
    //To display progess dialog
    private ProgressDialog pDialog;
    ListAdapter adapter;
    //Create a JSON parser object
    JSONParser jParser = new JSONParser();
    ArrayList<HashMap<String,gradesemester>> gradesList;
    //url to get grades from server
    private static String url_get_grades = "http://ec2-54-218-26-0.us-west-2.compute.amazonaws.com/android_connect/get_grades.php";
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_JNCT_USER_COURSE = "jnct_user_course";
    private static final String TAG_User_ID_FK = "User_ID_FK";
    private static final String TAG_Course_ID_FK = "Course_ID_FK";
    ListView lv;

    JSONArray grades = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grades_activity_layout);

        // Hashmap for ListView
        gradesList = new ArrayList<HashMap<String, gradesemester>>();

        // Loading grades in Background Thread
        new LoadAllGrades().execute();

        // Get listview
        ListView lv = getListView(); //comente este
          ///*ListView lv*/ lv = (ListView) findViewById(R.id.listView);
          lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // getting values from selected ListItem
                String pid = ((TextView) view.findViewById(R.id.id)).getText().toString();

                // Starting new intent
                Intent in = new Intent(getApplicationContext(),
                        EditProductActivity.class);
                // sending pid to next activity
                in.putExtra(TAG_User_ID_FK, pid);

                // starting new activity and expecting some response back
                startActivityForResult(in, 100);
            }
        });

    }
    /**
     * Background Async Task to Load all grades by making HTTP Request
     * */
    class LoadAllGrades extends AsyncTask<String, String, String> {

        /**
         * Before starting background thread Show Progress Dialog
         * */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(GradesActivity.this);
            pDialog.setMessage("Loading grades. Please wait...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        /**
         * getting All grades from url
         * */
        protected String doInBackground(String... args) {
            // Building Parameters
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair(TAG_User_ID_FK,"1"));
            params.add(new BasicNameValuePair(TAG_Course_ID_FK,"2"));

            // getting JSON string from URL
            JSONObject json = jParser.makeHttpRequest(url_get_grades, "GET", params);

            // Check your log cat for JSON reponse
            Log.d("Grades: ", json.toString());

            try {
                // Checking for SUCCESS TAG
                int success = json.getInt(TAG_SUCCESS);

                if (success == 1) {
                    // grades found
                    // Getting Array of grades
                    grades = json.getJSONArray(TAG_JNCT_USER_COURSE);
                    Log.d("grades2",grades.toString());

                    // looping through grades
                    for (int i = 0; i < grades.length(); i++) {
                        JSONObject c = grades.getJSONObject(i);

                        // Storing each json item in variable
                        String grade = c.getString("grade"); //change to string grade
                        String semester = c.getString("semester");

                        // creating new HashMap
                        HashMap<String, gradesemester> map = new HashMap<String, gradesemester>();

                        //con nueva clase
                        gradesemester gs = new gradesemester(semester,grade);

                        // adding each child node to HashMap key => value
                        map.put("object", gs);
                        //map.put("semester", semester);


                        // adding HashList to ArrayList
                        gradesList.add(map);
                        Log.d("gradesList",gradesList.toString());
                    }
                } else {
                    // no grades found
                    // Launch Add New grade Activity
                    Intent i = new Intent(getApplicationContext(),
                            NewProductActivity.class);
                    // Closing all previous activities
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        /**
         * After completing background task Dismiss the progress dialog
         * **/
        protected void onPostExecute(String file_url) {
            // dismiss the dialog after getting grades
            pDialog.dismiss();
            // updating UI from Background Thread
            runOnUiThread(new Runnable() {
                public void run() {
                    /**
                     * Updating parsed JSON data into ListView
                     * */



//                    adapter = new SimpleAdapter(
//                            GradesActivity.this, gradesList,
//                            R.layout.list_item, new String[] { //change grade % semester to userfk and coursefk
//                            "object"},                                       //only grade is printing
//                            new int[] { R.id.name}); //try changing id to userfk and name to coursefk
//                    // updating listview
//                    Log.d("adapter",adapter.toString());
//                    setListAdapter(adapter);
                    ArrayList<String> gradeSemList = new ArrayList<String>();

                    for(HashMap<String,gradesemester> item: gradesList){
                        gradesemester value = item.get("object");
                        gradeSemList.add(value.semester+": "+value.grade);
                    }

                    ArrayAdapter<String> adpt = new ArrayAdapter<>(GradesActivity.this, R.layout.list_item,R.id.name,gradeSemList);
                    getListView().setAdapter(adpt);



                }
            });

        }

    }




}
