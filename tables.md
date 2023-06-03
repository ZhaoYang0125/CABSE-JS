**user**

|  字段   | 类型  |
|  ----  | ----  |
| uid  | integer |
| username  | varchar |
| password  | varchar |
| state  | integer |

**teachers**
|  字段   | 类型  |
|  ----  | ----  |
| tid  | integer |
| username  | varchar |
| password  | varchar |
| state  | integer |

**admins**
|  字段   | 类型  |
|  ----  | ----  |
| aid  | integer |
| username  | varchar |
| password  | varchar |
| state  | integer |

**testpapers**：试卷

|  字段   | 类型  | 描述  |
|  ----  | ----  | ----  |
| paperid | integer  | 试卷id  |
|  url  | varchar | 试卷文件路径  |

**studentanswers**：学生答案

|  字段   | 类型  | 描述  |
|  ----  | ----  | ----  |
| answerid | integer  | 答案id  |
| paperid | integer  | 试卷id  |
| paperid | integer  | 学生id  |
| time  | timestamp | 答题日期 |
|  url  | varchar | 学生答案文件路径  |


**paperanswers**：标准答案

|  字段   | 类型  | 描述  |
|  ----  | ----  | ----  |
| answerid | integer  | 答案id  |
| paperid | integer  | 试卷id  |
|  url  | varchar | 标准答案文件路径  |

**reports**: 成绩报告
|  字段   | 类型  | 描述  |
|  ----  | ----  | ----  |
| reportid | integer  | 报告id  |
| studentid  | integer | 学生id  |
| paperid | integer  | 试卷id  |
|  listening  | integer | 听力分数  |
|  comprehension  | integer | 阅读理解分数  |
|  writing  | integer | 写作分数  |
|  translation  | integer | 翻译分数  |
|  time  | timestamp | 答题日期  |


TODO

**studuentprofiles**：学生信息表 
|  字段   | 类型  | 描述  |
|  ----  | ----  | ----  |
|  uid  | integer |  账号id  |
| studentid | integer  | 学生id  |
| gender | integer  | 性别  |
| age | integer  | 年龄  |
| school | varchar  | 学校  |
