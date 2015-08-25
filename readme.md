# A basic Android app and accompaning Java REST server

## Integrated development enviroments
### [Android Studio](http://developer.android.com/tools/studio/index.html)
### [IntelliJ](https://www.jetbrains.com/idea/)


They're really both the same thing

## The App

Create a new project and use the blank activity template

### Dependencies
#### [Retrofit](http://square.github.io/retrofit/)
This is the REST library we'll use to grab data from our server

#### build.gradle
Inside :

    dependencies {
        compile fileTree(dir: 'libs', include: ['*.jar'])
        testCompile 'junit:junit:4.12'
        compile 'com.android.support:appcompat-v7:22.2.1'
    }

Add:

    compile 'com.squareup.retrofit:retrofit:1.9.0'

So:

    dependencies {
        compile fileTree(dir: 'libs', include: ['*.jar'])
        testCompile 'junit:junit:4.12'
        compile 'com.android.support:appcompat-v7:22.2.1'
        compile 'com.squareup.retrofit:retrofit:1.9.0'
    }


#### Data
We'll start with the plain POJO used to represent some data sent between the app and the server.

    public class Job {
        private String position;
        private String location;

        public Job() {
            // Empty constructor for injecting
        }

        public Job(String position, String location) {
            this.position = position;
            this.location = location;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

    }

#### JobService.java
Create this interface so that we can build a Retrofit service with it.

    public interface JobService {

        @GET("/jobs")
        List<Job> listJobs();

        @POST("/jobs")
        void createJob(@Body Job job, Callback<Job> callback);

    }

#### MainActivity.java
This is where the whole of the app is built.

The following code is not relevant unless you're implementing drop down options, so you can remove it if you'd like:

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
