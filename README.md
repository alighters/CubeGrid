# CubeGrid
Cube grid animation about the android.

The android implementation about the [9-cube-grid](https://github.com/tobiasahlin/SpinKit/blob/master/examples/9-cube-grid.html)

## Demo
![test](http://7xpyth.com1.z0.glb.clouddn.com/cube1.gif)

## Usage
### Add dependency
	allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
	dependencies {
	        compile 'com.github.david-wei:CubeGrid:1.0.1'
	}
	
### Step 1
```
  <com.lighters.cubegridlibrary.view.CubeGridImageView
      android:id="@+id/iv_cube_grid"
      android:layout_width="100dp"
      android:layout_height="100dp"
      android:padding="12dp"
      android:src="@drawable/ic_launcher"
      app:fillColor="#f00"
      app:loopCount="10"
      app:roundCornerSize="6dp"/>

  <com.lighters.cubegridlibrary.view.CubeGridFrameLayout
      android:id="@+id/fl_cube_grid"
      android:layout_width="80dp"
      android:layout_marginTop="100dp"
      android:layout_height="80dp"
      app:fillColor="#0f0"
      app:loopCount="10"
      app:roundCornerSize="6dp"/>
```
### Step 2
```
public class MainActivity extends AppCompatActivity {

    private CubeGridImageView mCubeGridImageView;
    private CubeGridFrameLayout mCubeGridFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mCubeGridImageView = (CubeGridImageView) findViewById(R.id.iv_cube_grid);
        mCubeGridFrameLayout = (CubeGridFrameLayout) findViewById(R.id.fl_cube_grid);
        mCubeGridImageView.start(mCubeGridAnimCallback);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mCubeGridFrameLayout.start(mCubeGridAnimCallback);
            }
        }, 100);

    }

    private ICubeGridAnimCallback mCubeGridAnimCallback = new ICubeGridAnimCallback() {
        @Override
        public void onAnimStart() {

        }

        @Override
        public void onAnimEnd() {

        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCubeGridImageView.stop();
        mCubeGridFrameLayout.stop();
    }
}
```

## LICENSE

```
Copyright (C) 2016 david.wei (lighters)
 
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at
 
      http://www.apache.org/licenses/LICENSE-2.0
 
 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 