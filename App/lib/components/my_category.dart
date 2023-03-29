import 'package:camera/camera.dart';
import 'package:flutter/material.dart';
import '../screens/additem.dart';

class myCategoty extends StatelessWidget {
  const myCategoty({
    super.key,
    required List<String> frozenfood,
  }) : _frozenfood = frozenfood;

  final List<String> _frozenfood;

  @override
  Widget build(BuildContext context) {
    return Flexible(
        child: Column(
          children: [
            Padding(
              padding: const EdgeInsets.fromLTRB(10, 0, 10, 0),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  Container(
                    child: Text(
                      'FROZEN FOOD',
                      style: TextStyle(fontSize: 15, color: Colors.white),
                    ),
                    height: 25,
                    width: 120,
                    decoration: BoxDecoration(
                        borderRadius: BorderRadius.circular(7),
                        color: Color(0xff3b6fa5)),
                    alignment: Alignment.center,
                  ),
                  TextButton.icon(
                    onPressed: () async {
                      await availableCameras().then((value) => Navigator.push(context,
                          MaterialPageRoute(builder: (_) => AddItem(cameras: value))));
                    },
                    icon: const Icon(Icons.add, color: Color(0xff3b6fa5)),
                    label: const Text('Add',
                        style: TextStyle(color: Color(0xff3b6fa5))),
                  )
                ],
              ),
            ),
            SingleChildScrollView(
              child: Column(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  SizedBox(
                    height: 120,
                    child: ListView.builder(
                        itemCount: _frozenfood.length,
                        scrollDirection: Axis.horizontal,
                        itemBuilder: (context, index) => Container(
                          height: 80,
                          width: 150,
                          margin: EdgeInsets.fromLTRB(10, 5, 10, 5),
                          child: Center(
                            child: Column(
                              mainAxisAlignment:
                              MainAxisAlignment.spaceEvenly,
                              children: [
                                Text(_frozenfood[index]),
                                InkWell(
                                  onTap: () {},
                                  child: Container(
                                    padding: EdgeInsets.all(10),
                                    child: Text('DETAILS',
                                        style: TextStyle(
                                            fontWeight:
                                            FontWeight.bold)),
                                  ),
                                )
                              ],
                            ),
                          ),
                          decoration: BoxDecoration(
                              borderRadius: BorderRadius.circular(13),
                              color: Color(0xff92b7c7),
                              boxShadow: [
                                BoxShadow(
                                    color: Colors.grey.withOpacity(0.5),
                                    spreadRadius: 3,
                                    blurRadius: 5,
                                    offset: Offset(0, 2))
                              ]),
                        )),
                  )
                ],
              ),
            ),
          ],
        ));
  }
}
