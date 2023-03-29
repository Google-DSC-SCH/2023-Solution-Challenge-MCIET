/*class Food {
  final String name;
  final DateTime expirationDate;

  Food({required this.name, required this.expirationDate});
}

List<Map<dynamic, dynamic>> foodList = [
  {'name': '우유', 'expirationDate': DateTime(2023, 3, 26)},
  {'name': '빵', 'expirationDate': DateTime(2023, 3, 26)},
  {'name': '요구르트', 'expirationDate': DateTime(2023, 3, 27)},
  {'name': '치즈', 'expirationDate': DateTime(2023, 3, 28)},
  {'name': '닭가슴살', 'expirationDate': DateTime(2023, 3, 30)},
  {'name': '김치', 'expirationDate': DateTime(2023, 4, 1)},
];

List<Food> getExpiringFoods(List<Map<dynamic, dynamic>> foodList) {
  List<Food> expiringFoods = [];
  DateTime now = DateTime.now();

  for (Map<dynamic, dynamic> foodMap in foodList) {
    DateTime expirationDate = DateTime.parse(foodMap['expirationDate']);
    if (expirationDate.difference(now).inDays == 1) {
      expiringFoods.add(Food(
        name: foodMap['name'],
        expirationDate: expirationDate,
      ));
    }
  }

  return expiringFoods;
}
 */