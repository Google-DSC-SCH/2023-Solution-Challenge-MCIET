import 'dart:async';

import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:intl/intl.dart';
import 'package:solution_challenge_mciet/components/divider.dart';
import 'package:solution_challenge_mciet/components/myaccountinfo.dart';
import 'package:solution_challenge_mciet/model/drawer.dart';
import 'dart:core';
import 'package:http/http.dart' as http;
import 'package:solution_challenge_mciet/components/mycatecory.dart';
import 'package:solution_challenge_mciet/screens/additem.dart';
import 'package:camera/camera.dart';

class myrefPage extends StatefulWidget {
  const myrefPage({Key? key}) : super(key: key);

  @override
  State<myrefPage> createState() => _myrefPageState();
}

class _myrefPageState extends State<myrefPage> {
  final String accountName = FirebaseAuth.instance.currentUser!.displayName!;
  final String accountEmail = FirebaseAuth.instance.currentUser!.email!;

  var now = DateFormat('yyyy / MM').format(DateTime.now());

  @override
  Widget build(BuildContext context) {
    Size size = MediaQuery.of(context).size;
    return SafeArea(
      child: Scaffold(
        appBar: AppBar(
          elevation: 0,
          backgroundColor: const Color(0xff3b6fa5),
          title: const Text('M C I E T'),
          centerTitle: true,
          actions: [
            IconButton(
                onPressed: () {
                  showuserData();
                  showDialog(
                      context: context,
                      builder: (context) {
                        print(accountEmail);
                        print(accountName);
                        return myAccountInfo(accountName: accountName, accountEmail: accountEmail);
                      });
                },
                icon: const Icon(Icons.person))
          ],
        ),
        body: SingleChildScrollView(
          child: Column(
            children: [
              Container(
                  height: size.height * 0.13,
                  child: Stack(
                    children: <Widget>[
                      Container(
                        height: size.height * 0.2 - 70,
                        decoration: const BoxDecoration(
                            borderRadius: BorderRadius.only(
                                bottomLeft: Radius.circular(35),
                                bottomRight: Radius.circular(35)),
                            color: Color(0xff3b6fa5)),
                      ),
                      Positioned(
                          top: 10,
                          left: 0,
                          right: 0,
                          child: Container(
                            margin: const EdgeInsets.symmetric(horizontal: 30),
                            height: 55,
                            decoration: BoxDecoration(
                              color: Colors.white,
                              borderRadius: BorderRadius.circular(20),
                            ),
                            child: Padding(
                              padding: const EdgeInsets.symmetric(horizontal: 9),
                              child: Row(
                                children: [
                                  const Icon(Icons.kitchen, size: 45),
                                  Padding(
                                    padding:
                                        const EdgeInsets.fromLTRB(13, 9, 9, 9),
                                    child: Column(
                                      crossAxisAlignment:
                                          CrossAxisAlignment.start,
                                      children: [
                                        Text(
                                          now,
                                          style: TextStyle(fontSize: 13),
                                        ),
                                        const Text(
                                          'My Refrigerator',
                                          style: TextStyle(
                                              fontSize: 19,
                                              fontWeight: FontWeight.bold),
                                        )
                                      ],
                                    ),
                                  )
                                ],
                              ),
                            ),
                          )),
                    ],
                  )),
              CategoryWithAddBtn(title: "MEAT", c_color: 0xff7bbff6),
              SingleChildScrollView(
                scrollDirection: Axis.horizontal,
                child: Row(
                  children: [
                    MyIngredient(
                      ingredient: "Pork",
                      expirationdate: "2023-04-02",
                    ),
                    MyIngredient(
                      ingredient: "Beef",
                      expirationdate: "2023-03-31",
                    ),
                    MyIngredient(
                      ingredient: "Lamb",
                      expirationdate: "2023-04-02",
                    ),
                    MyIngredient(
                      ingredient: "Chicken Meat",
                      expirationdate: "2023-03-31",
                    ),
                  ],
                ),
              ),
              mydivider(),
              CategoryWithAddBtn(title: "FROZEN FOOD", c_color: 0xff83aff0),
              SingleChildScrollView(
                scrollDirection: Axis.horizontal,
                child: Row(
                  children: [
                    MyIngredient(
                      ingredient: "Icecream",
                      expirationdate: "2023-05-02",
                    ),
                    MyIngredient(
                      ingredient: "Pizza",
                      expirationdate: "2023-04-17",
                    ),
                  ],
                ),
              ),
              mydivider(),
              CategoryWithAddBtn(title: "SAUCE", c_color: 0xff4779c4),
              SingleChildScrollView(
                scrollDirection: Axis.horizontal,
                child: Row(
                  children: [
                    MyIngredient(
                      ingredient: "Ketchup",
                      expirationdate: "2025-05-21",
                    ),
                    MyIngredient(
                      ingredient: "Hot Sauce",
                      expirationdate: "2026-02-27",
                    ),
                    MyIngredient(
                      ingredient: "Tomato Sauce",
                      expirationdate: "2024-09-16",
                    ),
                    MyIngredient(
                      ingredient: "Mayonnaise",
                      expirationdate: "2023-04-01",
                    ),
                  ],
                ),
              ),
              mydivider(),
              CategoryWithAddBtn(title: "VEGETABLE & FRUITS", c_color: 0xff3c649f),
              SingleChildScrollView(
                scrollDirection: Axis.horizontal,
                child: Row(
                  children: [
                    MyIngredient(
                      ingredient: "Onion",
                      expirationdate: "2023-04-11",
                    ),
                    MyIngredient(
                      ingredient: "Strawberry",
                      expirationdate: "2023-03-31",
                    ),
                    MyIngredient(
                      ingredient: "Broccoli",
                      expirationdate: "2023-04-08",
                    ),
                    MyIngredient(
                      ingredient: "Carrot",
                      expirationdate: "2023-04-12",
                    ),MyIngredient(
                      ingredient: "Spinach",
                      expirationdate: "2023-04-13",
                    ),
                  ],
                ),
              ),
              mydivider(),
              CategoryWithAddBtn(title: "BEVERAGE", c_color: 0xff2c456b),
              SingleChildScrollView(
                scrollDirection: Axis.horizontal,
                child: Row(
                  children: [
                    MyIngredient(
                      ingredient: "Black Coffee",
                      expirationdate: "2023-03-31",
                    ),
                    MyIngredient(
                      ingredient: "Orange Juice",
                      expirationdate: "2023-04-06",
                    ),
                  ],
                ),
              ),
              mydivider(),
              CategoryWithAddBtn(title: "ETC", c_color: 0xff1b2d48),
              SingleChildScrollView(
                scrollDirection: Axis.horizontal,
                child: Row(
                  children: [
                    MyIngredient(
                      ingredient: "Kimchi",
                      expirationdate: "2025-01-01",
                    ),
                  ],
                ),
              ),
            ],
          ),
        ),
        drawer: mydrawer(accountName: accountName, accountEmail: accountEmail),
      ),
    );
  }
  Future<String?> showuserData() async {
    final url = Uri.parse('http://3.39.32.28:8080/user/show');

    final headers = {
      'Content-Type': 'application/json',
      'Authorization': ''
    };


    http.Response response = await http.get(
      url,
      headers: headers,

    );
    print(response.statusCode);
    if (response.statusCode >= 200 && response.statusCode < 300) {
      print("성공");
      print(response.body);
    }
    else {
      print("실패");
    }
  }
}


