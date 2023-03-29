import 'package:flutter/material.dart';

class Text_mciet extends StatelessWidget {
  const Text_mciet({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        Text(
          'M',
          style: TextStyle(color: Colors.amber, fontSize: 20),
        ),
        Text(
          'om, ',
          style: TextStyle(color: Colors.white, fontSize: 20),
        ),
        Text(
          'C',
          style: TextStyle(color: Colors.amber, fontSize: 20),
        ),
        Text(
          'an ',
          style: TextStyle(color: Colors.white, fontSize: 20),
        ),
        Text(
          'I ',
          style: TextStyle(color: Colors.amber, fontSize: 20),
        ),
        Text(
          'E',
          style: TextStyle(color: Colors.amber, fontSize: 20),
        ),
        Text(
          'at ',
          style: TextStyle(color: Colors.white, fontSize: 20),
        ),
        Text(
          'T',
          style: TextStyle(color: Colors.amber, fontSize: 20),
        ),
        Text(
          'his?',
          style: TextStyle(color: Colors.white, fontSize: 20),
        ),
      ],
    );
  }
}
