import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'memo.dart';
import 'checkexpidate.dart';
import 'myref.dart';

class homePage extends StatefulWidget {
  const homePage({Key? key}) : super(key: key);

  @override
  State<homePage> createState() => _homePageState();
}

class _homePageState extends State<homePage> {

  var _selectedIndex = 1;

  @override
  Widget build(BuildContext context) {
    return SafeArea(
      child: Scaffold(
        body: IndexedStack(
          index: _selectedIndex,
          children: [ // navigator 페이지
            CheckPage(),
            myrefPage(),
            memoPage(),
          ],
        ),
        bottomNavigationBar: buildBottomNavigationBar(),
      ),
    );
  }

  // 하단 네비게이터 화면 이동 및 디자인
  BottomNavigationBar buildBottomNavigationBar() {
    return BottomNavigationBar(
      currentIndex: _selectedIndex,
      showSelectedLabels: false,
      showUnselectedLabels: false,
      selectedItemColor: Color(0xff3b6fa5),
      selectedIconTheme: IconThemeData(
          size: 40
      ),
      onTap: (value) {
        setState(() {
          _selectedIndex = value;
        });
      },

      items: [
        BottomNavigationBarItem(
            icon: Icon(Icons.restaurant),
            label: 'COOK'),
        BottomNavigationBarItem(
            icon: Icon(Icons.home),
            label: 'HOME'),
        BottomNavigationBarItem(
            icon: Icon(Icons.mode),
            label: 'MEMO',
        ),
      ],
    );
  }
}