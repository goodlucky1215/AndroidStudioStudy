import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'First app~~',
      theme: ThemeData(
        primarySwatch: Colors.blue //색상을 지정하는 것
      ), //ThemeData => 앱의 기본적인 디자인 테마를 지정하는 것
      home: MyHomePage(), //home => 화면을 키면 가장 먼저 보여지는 화면 
    );
  }
}
