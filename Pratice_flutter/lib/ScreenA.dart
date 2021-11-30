import 'package:flutter/material.dart';

class ScreenA extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('It main time!!!'),
      ),
      body: Center(
        child: Column(
          children: <Widget>[
            RaisedButton(
                color: Colors.red,
                child: Text('gogogogog BBBBB'),
                onPressed: (){
                  Navigator.pushNamed(context, '/b');
                },
            ),
            RaisedButton(
              color: Colors.red,
              child: Text('gogogogog CCCCCCC'),
              onPressed: (){
                Navigator.pushNamed(context, '/c');
              },
            ),
          ],
        ),
      ),
    );
  }
}
