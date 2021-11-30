import 'package:flutter/material.dart';
import 'package:pratice_flutter/ScreenA.dart';
import 'package:pratice_flutter/ScreenB.dart';
import 'package:pratice_flutter/ScreenC.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      initialRoute: '/',
      routes: {
        '/' : (context) => ScreenA(),
        '/b' : (context) => ScreenB(),
        '/c' : (context) => ScreenC()
      },
    );
  }
}

/*
class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'First app~~',
      theme: ThemeData(
        primarySwatch: Colors.blue //색상을 지정하는 것
      ), //ThemeData => 앱의 기본적인 디자인 테마를 지정하는 것
      home: MyHomePage(), //home => 화면을 키면 가장 먼저 보여지는 화면
    );
  }
}


class MyHomePage extends StatelessWidget {
  const MyHomePage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context2) {
    return Scaffold(
      backgroundColor: Colors.amber[300],
      appBar: AppBar(
        title: Text('This is appbar\'s Title!!'),
        centerTitle: true,
        backgroundColor: Colors.amber[700],
        elevation: 0.0,
      ),
      body: Container(
        color: Colors.red,
        padding: EdgeInsets.fromLTRB(30.0,40.0,0,0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: <Widget>[
            Text('이름',
            style: TextStyle(
              color: Colors.white,
              letterSpacing: 2.0,
              fontSize: 20.0
            ),
            ),
            SizedBox(
              height: 10.0,
            ),
            Text('Strong Hamster',
            style: TextStyle(
              color: Colors.white,
              letterSpacing: 2.0,
              fontSize: 28.0,
              fontWeight: FontWeight.bold
            ),
            ),
            SizedBox(
              height: 30.0,
            ),
            Text('He is POWER LEVEL👊',
              style: TextStyle(
                  color: Colors.white,
                  letterSpacing: 2.0,
                  fontSize: 20.0
              ),
            ),
            SizedBox(
              height: 10.0,
            ),
            Text('53',
              style: TextStyle(
                  color: Colors.white,
                  letterSpacing: 2.0,
                  fontSize: 28.0,
                  fontWeight: FontWeight.bold
              ),
            ),
            SizedBox(
              height: 30.0,
            ),
            Text('SKILL🔥',
              style: TextStyle(
                  color: Colors.white,
                  letterSpacing: 2.0,
                  fontSize: 20.0
              ),
            ),
            SizedBox(
              height: 10.0,
            ),
            Row(
              children: <Widget>[
                Icon(Icons.check_circle_outline),
                SizedBox(
                  width: 10,
                ),
                Text('cuty attack',
                style: TextStyle(
                  fontSize: 16.0,
                  letterSpacing: 1.0
                ),
                ),
              ],
            ),
            SizedBox(
              height: 10,
            ),
            Row(
              children: <Widget>[
                Icon(Icons.check_circle_outline),
                SizedBox(
                  width: 10,
                ),
                Text('hide food',
                  style: TextStyle(
                      fontSize: 16.0,
                      letterSpacing: 1.0
                  ),
                ),
              ],
            ),
            SizedBox(
              height: 10,
            ),
            Row(
              children: <Widget>[
                Icon(Icons.check_circle_outline),
                SizedBox(
                  width: 10,
                ),
                Text('sniff',
                  style: TextStyle(
                      fontSize: 16.0,
                      letterSpacing: 1.0
                  ),
                ),
              ],
            ),
            SizedBox(
              height: 30.0,
            ),
            ButtonTheme(
              minWidth: 100,
              height: 50,
              child: RaisedButton(
                color: Colors.orangeAccent,
                child: Icon(
                  Icons.arrow_forward,
                  color: Colors.white,
                  size: 35,
                ),
                onPressed: (){
                  //MaterialPageRoute(builder:(BuildContext context)=>Dice());
                  Navigator.push(context2, MaterialPageRoute(
                      builder: (BuildContext context){
                        return SecondPage();
                      }
                      ));
                }
              ),
            ),
            SizedBox(
              height: 30.0,
            ),
            ButtonTheme(
              minWidth: 100,
              height: 50,
              child: RaisedButton(
                  color: Colors.orangeAccent,
                  child: Text('Go to the 두번째!'),
                  onPressed: (){
                    //MaterialPageRoute(builder:(BuildContext context)=>Dice());
                    Navigator.push(context2, MaterialPageRoute(
                        builder: (context) => SecondPage() // == (_) => SecondPage() (_) 언더바는 필요없는 매개변수를 표시할 때 사용(플러터에서 권장사항)
                    ));
                  }
              ),
            ),
          ],
        ),
      ),
    );
  }
}

class SecondPage extends StatelessWidget {
  const SecondPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext ctx) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Second Page'),
      ),
      body: Center(
        child: RaisedButton(
          child: Text('go to the First page'),
          onPressed: (){
            Navigator.pop(ctx);
          },
        ),
      ),
    );
  }
}
*/