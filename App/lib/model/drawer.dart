import 'package:flutter/material.dart';
import 'package:solution_challenge_mciet/components/myaccountinfo.dart';
import 'package:solution_challenge_mciet/services/auth_service.dart';
import 'package:get/get.dart';

class mydrawer extends StatelessWidget {
  const mydrawer({
    super.key,
    required this.accountName,
    required this.accountEmail,
  });

  final String accountName;
  final String accountEmail;

  @override
  Widget build(BuildContext context) {
    return Drawer(
      // 사이드바
      child: Container(
        child: ListView(
          children: [
            UserAccountsDrawerHeader(
              decoration: BoxDecoration(color: Color(0xff3b6fa5)),
              accountName: Text(accountName), // 유저이름
              accountEmail: Text(accountEmail), // 유저이메일
              currentAccountPicture: CircleAvatar(
                  backgroundImage:
                  AssetImage('lib/images/ciety.png'),
                  child: ClipOval()),
            ),
            ListTile(
              leading: Icon(Icons.home),
              title: Text(
                'Home',
                style: TextStyle(fontSize: 20),
              ),
              onTap: () {

              },
            ),
            ListTile(
              leading: Icon(Icons.person),
              title: Text(
                'My Account',
                style: TextStyle(fontSize: 20),
              ),
              onTap: () {
                showDialog(
                    context: context,
                    builder: (context) {
                      return myAccountInfo(accountName: accountName, accountEmail: accountEmail);
                    });
              },
            ),
            Divider(
              color: Colors.black,
              height: 5,
              indent: 10,
            ),
            ListTile(
              leading: Icon(Icons.exit_to_app),
              title: Text(
                'Logout',
                style: TextStyle(fontSize: 20),
              ),
              onTap: () {
                AuthService().signOut();
              },
            )
          ],
        ),
      ),
    );
  }
}

