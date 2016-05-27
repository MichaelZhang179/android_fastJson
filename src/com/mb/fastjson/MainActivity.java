package com.mb.fastjson;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.alibaba.fastjson.JSON;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		List<StudentInfo> list = new ArrayList<>();
		StudentInfo studentA = new StudentInfo("001", "小A", 18);
		StudentInfo studentB = new StudentInfo("002", "小B", 18);
		StudentInfo studentC = new StudentInfo("003", "小C", 18);
		StudentInfo studentD = new StudentInfo("004", "小D", 18);
		list.add(studentA);
		list.add(studentB);
		list.add(studentC);
		list.add(studentD);
		
		List<StudentInfo> list2 = new ArrayList<>();
		StudentInfo studenta = new StudentInfo("005", "小a", 18);
		StudentInfo studentb = new StudentInfo("006", "小b", 18);
		StudentInfo studentc = new StudentInfo("007", "小c", 18);
		StudentInfo studentd = new StudentInfo("008", "小d", 18);
		list2.add(studenta);
		list2.add(studentb);
		list2.add(studentc);
		list2.add(studentd);
		
		String jsonA = JSON.toJSONString(studentA);
		Log.e("jb", "实体json字符串-----"+jsonA);
		String jsonList = JSON.toJSONString(list);
		Log.e("jb", "数组json字符串----"+jsonList);
		List<StudentInfo> lists = new ArrayList<>();
		lists = JSON.parseArray(jsonList,StudentInfo.class);
		for (int i = 0; i < lists.size(); i++) {
			Log.e("jb", i+"--解析数组---"+lists.get(i));
		}
		StudentInfo user = JSON.parseObject(jsonA,StudentInfo.class);
		Log.e("jb", "解析实体——————"+user.toString());
		
		List<ClassInfo> listClass = new ArrayList<>();
		ClassInfo classInfo = new ClassInfo("C1","一班",list);
		ClassInfo classInfo2 = new ClassInfo("C2","二班",list2);
		listClass.add(classInfo);
		listClass.add(classInfo2);
		String jsonClass = JSON.toJSONString(listClass);
		Log.e("jb", "嵌套json字符串-----"+jsonClass);
		List<ClassInfo> listClass2 = new ArrayList<>();
		listClass2 = JSON.parseArray(jsonClass, ClassInfo.class);
		for (int i = 0; i < listClass2.size(); i++) {
			Log.e("jb", i+"___解析嵌套数据"+listClass2.get(i).toString());
		}
	}
//  log 如下：
//	04-26 17:40:24.454: E/jb(1769): 实体json字符串-----{"age":18,"id":"001","name":"小A"}
//	04-26 17:40:24.464: E/jb(1769): 数组json字符串----[{"age":18,"id":"001","name":"小A"},{"age":18,"id":"002","name":"小B"},{"age":18,"id":"003","name":"小C"},{"age":18,"id":"004","name":"小D"}]
//	04-26 17:40:24.464: E/jb(1769): 0--解析数组---StudentInfo [id=001, name=小A, age=18]
//	04-26 17:40:24.464: E/jb(1769): 1--解析数组---StudentInfo [id=002, name=小B, age=18]
//	04-26 17:40:24.464: E/jb(1769): 2--解析数组---StudentInfo [id=003, name=小C, age=18]
//	04-26 17:40:24.464: E/jb(1769): 3--解析数组---StudentInfo [id=004, name=小D, age=18]
//	04-26 17:40:24.464: E/jb(1769): 解析实体——————StudentInfo [id=001, name=小A, age=18]
//	04-26 17:40:24.464: E/jb(1769): 嵌套json字符串-----[{"id":"C1","name":"一班","students":[{"age":18,"id":"001","name":"小A"},{"age":18,"id":"002","name":"小B"},{"age":18,"id":"003","name":"小C"},{"age":18,"id":"004","name":"小D"}]},{"id":"C2","name":"二班","students":[{"age":18,"id":"005","name":"小a"},{"age":18,"id":"006","name":"小b"},{"age":18,"id":"007","name":"小c"},{"age":18,"id":"008","name":"小d"}]}]
//	04-26 17:40:24.464: E/jb(1769): 0___解析嵌套数据ClassInfo [id=C1, name=一班, students=[StudentInfo [id=001, name=小A, age=18], StudentInfo [id=002, name=小B, age=18], StudentInfo [id=003, name=小C, age=18], StudentInfo [id=004, name=小D, age=18]]]
//	04-26 17:40:24.464: E/jb(1769): 1___解析嵌套数据ClassInfo [id=C2, name=二班, students=[StudentInfo [id=005, name=小a, age=18], StudentInfo [id=006, name=小b, age=18], StudentInfo [id=007, name=小c, age=18], StudentInfo [id=008, name=小d, age=18]]]

}
