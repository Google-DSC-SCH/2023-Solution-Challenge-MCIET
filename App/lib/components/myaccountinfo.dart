import 'package:flutter/material.dart';

class myAccountInfo extends StatelessWidget {
  const myAccountInfo({
    super.key,
    required this.accountName,
    required this.accountEmail,
  });

  final String accountName;
  final String accountEmail;

  @override
  Widget build(BuildContext context) {
    return AlertDialog(
      content: Column(
        mainAxisSize: MainAxisSize.min,
        children: [
          Container(
            color: Color(0xff3b6fa5),
            height: 40,
            width: MediaQuery.of(context).size.width,
            child: const Center(
              child: Text('My Account Information',
                style: TextStyle(
                    color: Colors.white,
                    fontSize: 16,
                    fontWeight: FontWeight.w600
                ),),
            ),
          ),
          SizedBox(
            height: 15,
          ),
          Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Column(
                mainAxisAlignment: MainAxisAlignment.start,
                children: [
                  Container(
                    child: Text('Name'),
                    decoration: BoxDecoration(
                        color: Color(0xff92b7c7),
                        borderRadius: BorderRadius.circular(5)
                    ),
                    padding: EdgeInsets.all(5),
                  ),
                  SizedBox(height: 10),
                  Container(
                    child: Text('Email'),
                    decoration: BoxDecoration(
                        color: Color(0xff92b7c7),
                        borderRadius: BorderRadius.circular(5)
                    ),
                    padding: EdgeInsets.all(5),
                  ),
                ],
              ),
              SizedBox(width: 20),
              Column(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  Text(accountName),
                  SizedBox(height: 15),
                  Text(accountEmail),
                ],
              )
            ],
          )
        ],
      ),
    );
  }
}
