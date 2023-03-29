import 'package:flutter/material.dart';

class mydivider extends StatelessWidget {
  const mydivider({
    super.key,
  });

  @override
  Widget build(BuildContext context) {
    return Container(
      width: 350,
      child: Divider(
        color: Colors.black26,
        thickness: 1,
      ),
    );
  }
}