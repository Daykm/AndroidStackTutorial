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


# Dillinger

Dillinger is a cloud-enabled, mobile-ready, offline-storage, AngularJS powered HTML5 Markdown editor.

  - Type some Markdown on the left
  - See HTML in the right
  - Magic

Markdown is a lightweight markup language based on the formatting conventions that people naturally use in email.  As [John Gruber] writes on the [Markdown site] [1]:

> The overriding design goal for Markdown's
> formatting syntax is to make it as readable
> as possible. The idea is that a
> Markdown-formatted document should be
> publishable as-is, as plain text, without
> looking like it's been marked up with tags
> or formatting instructions.

This text you see here is *actually* written in Markdown! To get a feel for Markdown's syntax, type some text into the left window and watch the results in the right.

### Version
3.0.2

### Tech

Dillinger uses a number of open source projects to work properly:

* [AngularJS] - HTML enhanced for web apps!
* [Ace Editor] - awesome web-based text editor
* [Marked] - a super fast port of Markdown to JavaScript
* [Twitter Bootstrap] - great UI boilerplate for modern web apps
* [node.js] - evented I/O for the backend
* [Express] - fast node.js network app framework [@tjholowaychuk]
* [Gulp] - the streaming build system
* [keymaster.js] - awesome keyboard handler lib by [@thomasfuchs]
* [jQuery] - duh

And of course Dillinger itself is open source with a [public repository](https://github.com/joemccann/dillinger) on GitHub.

### Installation

You need Gulp installed globally:

```sh
$ npm i -g gulp
```

```sh
$ git clone [git-repo-url] dillinger
$ cd dillinger
$ npm i -d
$ mkdir -p public/files/{md,html,pdf}
$ gulp build --prod
$ NODE_ENV=production node app
```

### Plugins

Dillinger is currently extended with the following plugins

* Dropbox
* Github
* Google Drive
* OneDrive

Readmes, how to use them in your own application can be found here:

* [plugins/dropbox/README.md](https://github.com/joemccann/dillinger/tree/master/plugins/dropbox/README.md)
* [plugins/github/README.md](https://github.com/joemccann/dillinger/tree/master/plugins/github/README.md)
* [plugins/googledrive/README.md](https://github.com/joemccann/dillinger/tree/master/plugins/googledrive/README.md)
* [plugins/onedrive/README.md](https://github.com/joemccann/dillinger/tree/master/plugins/onedrive/README.md)

### Development

Want to contribute? Great!

Dillinger uses Gulp + Webpack for fast developing.
Make a change in your file and instantanously see your updates!

Open your favorite Terminal and run these commands.

First Tab:
```sh
$ node app
```

Second Tab:
```sh
$ gulp watch
```

(optional) Third:
```sh
$ karma start
```

### Todos

 - Write Tests
 - Rethink Github Save
 - Add Code Comments
 - Add Night Mode

License
----

MIT


**Free Software, Hell Yeah!**

- [john gruber](http://daringfireball.net)
- [@thomasfuchs](http://twitter.com/thomasfuchs)
- [1](http://daringfireball.net/projects/markdown/)
- [marked](https://github.com/chjj/marked)
- [Ace Editor](http://ace.ajax.org)
- [node.js](http://nodejs.org)
- [Twitter Bootstrap](http://twitter.github.com/bootstrap/)
- [keymaster.js](https://github.com/madrobby/keymaster)
- [jQuery](http://jquery.com)
- [@tjholowaychuk](http://twitter.com/tjholowaychuk)
- [express](http://expressjs.com)
- [AngularJS](http://angularjs.org)
- [Gulp](http://gulpjs.com)
