import 'package:flutter/material.dart';

class ScreenB extends StatelessWidget {
  const ScreenB({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('이건 B'),
      ),
      body: Center(
        child: Text('이건 B다다다다다'),
      ),
    );
  }
}
