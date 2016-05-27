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
		StudentInfo studentA = new StudentInfo("001", "СA", 18);
		StudentInfo studentB = new StudentInfo("002", "СB", 18);
		StudentInfo studentC = new StudentInfo("003", "СC", 18);
		StudentInfo studentD = new StudentInfo("004", "СD", 18);
		list.add(studentA);
		list.add(studentB);
		list.add(studentC);
		list.add(studentD);
		
		List<StudentInfo> list2 = new ArrayList<>();
		StudentInfo studenta = new StudentInfo("005", "Сa", 18);
		StudentInfo studentb = new StudentInfo("006", "Сb", 18);
		StudentInfo studentc = new StudentInfo("007", "Сc", 18);
		StudentInfo studentd = new StudentInfo("008", "Сd", 18);
		list2.add(studenta);
		list2.add(studentb);
		list2.add(studentc);
		list2.add(studentd);
		
		String jsonA = JSON.toJSONString(studentA);
		Log.e("jb", "ʵ��json�ַ���-----"+jsonA);
		String jsonList = JSON.toJSONString(list);
		Log.e("jb", "����json�ַ���----"+jsonList);
		List<StudentInfo> lists = new ArrayList<>();
		lists = JSON.parseArray(jsonList,StudentInfo.class);
		for (int i = 0; i < lists.size(); i++) {
			Log.e("jb", i+"--��������---"+lists.get(i));
		}
		StudentInfo user = JSON.parseObject(jsonA,StudentInfo.class);
		Log.e("jb", "����ʵ�塪����������"+user.toString());
		
		List<ClassInfo> listClass = new ArrayList<>();
		ClassInfo classInfo = new ClassInfo("C1","һ��",list);
		ClassInfo classInfo2 = new ClassInfo("C2","����",list2);
		listClass.add(classInfo);
		listClass.add(classInfo2);
		String jsonClass = JSON.toJSONString(listClass);
		Log.e("jb", "Ƕ��json�ַ���-----"+jsonClass);
		List<ClassInfo> listClass2 = new ArrayList<>();
		listClass2 = JSON.parseArray(jsonClass, ClassInfo.class);
		for (int i = 0; i < listClass2.size(); i++) {
			Log.e("jb", i+"___����Ƕ������"+listClass2.get(i).toString());
		}
	}
//  log ���£�
//	04-26 17:40:24.454: E/jb(1769): ʵ��json�ַ���-----{"age":18,"id":"001","name":"СA"}
//	04-26 17:40:24.464: E/jb(1769): ����json�ַ���----[{"age":18,"id":"001","name":"СA"},{"age":18,"id":"002","name":"СB"},{"age":18,"id":"003","name":"СC"},{"age":18,"id":"004","name":"СD"}]
//	04-26 17:40:24.464: E/jb(1769): 0--��������---StudentInfo [id=001, name=СA, age=18]
//	04-26 17:40:24.464: E/jb(1769): 1--��������---StudentInfo [id=002, name=СB, age=18]
//	04-26 17:40:24.464: E/jb(1769): 2--��������---StudentInfo [id=003, name=СC, age=18]
//	04-26 17:40:24.464: E/jb(1769): 3--��������---StudentInfo [id=004, name=СD, age=18]
//	04-26 17:40:24.464: E/jb(1769): ����ʵ�塪����������StudentInfo [id=001, name=СA, age=18]
//	04-26 17:40:24.464: E/jb(1769): Ƕ��json�ַ���-----[{"id":"C1","name":"һ��","students":[{"age":18,"id":"001","name":"СA"},{"age":18,"id":"002","name":"СB"},{"age":18,"id":"003","name":"СC"},{"age":18,"id":"004","name":"СD"}]},{"id":"C2","name":"����","students":[{"age":18,"id":"005","name":"Сa"},{"age":18,"id":"006","name":"Сb"},{"age":18,"id":"007","name":"Сc"},{"age":18,"id":"008","name":"Сd"}]}]
//	04-26 17:40:24.464: E/jb(1769): 0___����Ƕ������ClassInfo [id=C1, name=һ��, students=[StudentInfo [id=001, name=СA, age=18], StudentInfo [id=002, name=СB, age=18], StudentInfo [id=003, name=СC, age=18], StudentInfo [id=004, name=СD, age=18]]]
//	04-26 17:40:24.464: E/jb(1769): 1___����Ƕ������ClassInfo [id=C2, name=����, students=[StudentInfo [id=005, name=Сa, age=18], StudentInfo [id=006, name=Сb, age=18], StudentInfo [id=007, name=Сc, age=18], StudentInfo [id=008, name=Сd, age=18]]]

}
