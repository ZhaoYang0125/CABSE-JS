**user**

|  字段   | 类型  | 描述 |
|  ----  | ----  |  ----  |
| uid  | integer | 账号id |
| username  | varchar | 用户名 |
| password  | varchar | 密码 |
| state  | integer | 账号状态 |

**teacher**

|  字段   | 类型  | 描述 |
|  ----  | ----  |  ----  |
| tid  | integer | 账号id |
| username  | varchar | 用户名 |
| password  | varchar | 密码 |
| state  | integer | 账户状态 |
| jobnumber | integer | 工号 |

**admin**

|  字段   | 类型  | 描述 |
|  ----  | ----  |  ----  |
| aid  | integer | 账号id |
| username  | varchar | 用户名 |
| password  | varchar | 密码 |
| state  | integer | 账号状态 |
| token | varchar | 管理员令牌 |

**testpapers**

|  字段   | 类型  | 描述  |
|  ----  | ----  | ----  |
| paperid | integer  | 试卷id  |
|  url  | varchar | 试卷文件路径  |

**studentanswers**

|  字段   | 类型  | 描述  |
|  ----  | ----  | ----  |
| answerid | integer  | 答案id  |
| paperid | integer  | 试卷id  |
| paperid | integer  | 学生id  |
| time  | timestamp | 答题日期 |
|  url  | varchar | 学生答案文件路径  |

**paperanswers**

|  字段   | 类型  | 描述  |
|  ----  | ----  | ----  |
| answerid | integer  | 答案id  |
| paperid | integer  | 试卷id  |
|  url  | varchar | 标准答案文件路径  |

**reports**

|  字段   | 类型  | 描述  |
|  ----  | ----  | ----  |
| reportid | integer  | 报告id  |
| sid  | integer | 学生id  |
| paperid | integer  | 试卷id  |
|  listening  | integer | 听力分数  |
|  comprehension  | integer | 阅读理解分数  |
|  writing  | integer | 写作分数  |
|  translation  | integer | 翻译分数  |
|  time  | timestamp | 答题日期  |

**studuentprofiles** 

|  字段   | 类型  | 描述  |
|  ----  | ----  | ----  |
|  uid  | integer |  账号id  |
| sid | integer  | 学生id  |
| gender | integer  | 性别  |
| age | integer  | 年龄  |
| school | varchar  | 学校  |
