import 'package:http/http.dart';
import 'dart:convert';

class Todo
{
  String title="";
  bool completed=false;
  String id;
  
  Todo({required this.id});

  Future<void> getApiData() async
  {
    try {
      var url = Uri.https('jsonplaceholder.typicode.com', '/todos/1');
      Response response = await get(url);
      Map todo = jsonDecode(response.body);
      title = todo['title'];
      completed = todo['completed'];
    }catch(e)
    {
      print('caught error $e');
      title="error in api call";
    }
  }
}