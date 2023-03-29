import 'package:flutter/material.dart';
import 'package:solution_challenge_mciet/model/checklist.dart';

class CheckPage extends StatefulWidget {
  const CheckPage({Key? key}) : super(key: key);

  @override
  State<CheckPage> createState() => _CheckPageState();
}

class _CheckPageState extends State<CheckPage> {

  @override
  Widget build(BuildContext context) {
    Size size = MediaQuery
        .of(context)
        .size;
    return Scaffold(
      appBar: AppBar(
        elevation: 0,
        backgroundColor: Color(0xff3b6fa5),
        title: Text('M C I E T'),
        centerTitle: true,
      ),
      body: SingleChildScrollView(
        child: Column(
          children: <Widget>[
            Container(
                height: size.height * 0.13,
                child: Stack(
                  children: <Widget>[
                    Container(
                      height: size.height * 0.2 - 70,
                      decoration: BoxDecoration(
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
                          margin: EdgeInsets.symmetric(horizontal: 30),
                          height: 55,
                          decoration: BoxDecoration(
                            color: Colors.white,
                            borderRadius: BorderRadius.circular(20),
                          ),
                          child: Padding(
                            padding: const EdgeInsets.symmetric(horizontal: 7),
                            child: Center(
                              child: Text(
                                'My CheckList',
                                style: TextStyle(
                                    fontSize: 19, fontWeight: FontWeight.bold),
                              ),
                            ),
                          ),
                        )),
                  ],
                )),
            Padding(
              padding: const EdgeInsets.all(8.0),
              child: Column(
                children: [
                  Container(
                    child: Row(
                      children: [
                        Expanded(
                          child: Divider(
                            thickness: 1,
                            color: Colors.black,
                          ),
                        ),
                        Container(
                          padding: EdgeInsets.only(left: 8, right: 8),
                          child: Text(
                              'Expires in one day',
                              style: TextStyle(
                                color: Colors.red,
                                fontWeight: FontWeight.bold,
                                fontSize: 20
                              )
                          ),
                        ),
                        Expanded(child: Divider(
                          thickness: 1,
                          color: Colors.black,
                        )),
                      ],
                    ),
                  ),
                  SizedBox(height: 20),
                  onedayitemlist(onedayitem: 'Chiken meat',category: 'MEAT'),
                  onedayitemlist(onedayitem: 'Beef',category: 'MEAT'),
                  onedayitemlist(onedayitem: 'Strawberry',category: 'VEGETABLE & FRUITS'),
                  onedayitemlist(onedayitem: 'Black Coffee',category: 'BEVERAGE'),
                ],
              ),
            )
          ],
        ),
      ),
    );
  }
}

class onedayitemlist extends StatelessWidget {
  const onedayitemlist({
    super.key,
    required this.onedayitem,
    required this.category
  });

  final String onedayitem;
  final String category;

  @override
  Widget build(BuildContext context) {
    return Container(
      margin: EdgeInsets.all(8),
      padding: EdgeInsets.only(top: 10, left: 15, right: 15),
      height: 70,
      width: 300,
      decoration: BoxDecoration(
          color: Colors.blueGrey[100],
          borderRadius: BorderRadius.circular(13),
          boxShadow: [
            BoxShadow(
              offset: Offset(0, 13),
              blurRadius: 8,
              spreadRadius: -13,
            )
          ]
      ),
      child: Row(
        children: [
          Expanded(
              child: Column(
                children: [
                  Text(onedayitem,
                    style: TextStyle(
                        fontWeight: FontWeight.bold,
                        fontSize: 15
                    ),),
                  SizedBox(
                    height: 15,
                  ),
                  Text(category
                  )
                ],
              ))
        ],
      ),
    );
  }
}
