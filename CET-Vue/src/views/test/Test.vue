<template>
    <div class="paper_info_container">
        <div class="question_wrap">
            <el-scrollbar style="height: 100%">
                <el-card shadow="never">
                    <div class="exam_title">大学英语六级考试试题</div>
                    <div
                            v-for="question of paperInfo.questionList"
                            :key="question.id"
                            class="question_list_wrap"
                    >
                        <div class="question_item_wrap">
                            <div class="type_title">{{ question.typeName }}</div>
                            <div
                                    class="question_item"
                            >
                            <p class="question_title" :id="'ques_'+question.id">
                                {{ num+1 }}、
                                <span>{{ question.title }}</span>
                                <span>({{ question.score }}分)</span>
                            </p>
                            <!-- 听力 -->
                            <div v-if="question.type == 1" class="single_choice_wrap choice_wrap">
                                <el-radio-group
                                        @change="singleChoiceChange()"
                                        class="choice_item_wrap"
                                        v-model="item.stuAnswer">
                                    <el-radio
                                            v-for="(choice, index) of question.choices"
                                            :key="index"
                                            :label="choice"
                                            class="choice_item"
                                    >
                                        {{ String.fromCharCode((97 + index)+'').toUpperCase() }}.
                                        <span>{{ choice }}</span>
                                    </el-radio>
                                </el-radio-group>
                            </div>
                        <!-- 翻译/写作 -->
                        <div v-else-if="question.type == 4" class="short_answer_wrap choice_wrap">
                            <el-input
                                    type="textarea"
                                    placeholder="请输入内容"
                                    v-model="item.stuAnswer ">
                            </el-input>
                        </div>
                    </div>
                    </div>
                    </div>
                </el-card>
            </el-scrollbar>
        </div>
        <div class="marker_wrap">
            <div class="question_marker_wrap">
                <div
                        v-for="question of paperInfo.questionList"
                        :key="question.id"
                        class="question_item_wrap"
                >
                    <p class="question_type_title">{{ question.typeName }}</p>
                    <div class="marker_item_wrap">
                        <a :href="'#ques_'+question.id">{{ num+1 }}</a>
                    </div>
                </div>
            </div>
            <div class="btn_wrap">
                <el-button type="primary" plain size="small" @click="submitPaper">交卷</el-button>
            </div>
        </div>
    </div>
</template>
<script>
    export default {
        data() {
            return {
                paperInfo: {},
                isSubmit: false,
            }
        },
        created() {
            this.init()
        },
        methods: {
            init() {
                this.getPaperInfo();
            },
            getPaperInfo(){
                this.axios({
                    url: "/api/test/paper",               // 请求地址
                    method: "get",                       // 请求方法

                    success: (res) => {
                        if (res.data != null) {
                            this.paperInfo = res.data;
                        }
                    },
                });
            },
            singleChoiceChange() {
                let temp = JSON.parse(JSON.stringify(this.paperInfo))
                this.paperInfo = {}
                this.paperInfo = temp
            },
        }
    }
</script>
<style lang="scss">
    .paper_info_container{
        display: flex;
        justify-content: center;
        padding-top: 30px;
        .question_wrap{
            width: 1100px;
            height: calc(100vh - 30px);
            .exam_title{
                display: flex;
                align-items: center;
                justify-content: center;
                font-size: 18px;
                font-family: Arial, Helvetica, sans-serif;
                margin-bottom: 30px;
            }
            .el-scrollbar__wrap{
                overflow-x: hidden;
                scroll-behavior: smooth;
            }
            .question_item_wrap{
                .type_title{
                    font-size: 16px;
                    background: #dff9fb;
                    padding: 10px;
                    border-radius: 5px;
                    margin-bottom: 20px;
                }
                .question_item{
                    margin-bottom: 30px;
                    .question_title{
                        font-size: 15px;
                        padding-bottom: 10px;
                    }
                    .choice_wrap{
                        margin: 0 35px;
                        .choice_item_wrap{
                            display: flex;
                            flex-direction: column;
                            .el-radio__label,
                            .el-checkbox__label{
                                padding-left: 5px;
                                span{
                                    padding-left: 5px;
                                }
                            }
                            .el-checkbox__label{
                                padding-left: 10px;
                            }
                        }
                        .judge_choice_item_wrap{
                            .el-radio__label i{
                                font-weight: bold;
                                font-size: 18px;
                            }
                        }
                        .gap_fill_item_wrap{
                            display: flex;
                            align-items: center;
                            &>div{
                                width: 25%;
                                display: flex;
                                align-items: end;
                                padding: 0 5px;
                                .el-input{
                                    .el-input__inner{
                                        border: none;
                                        border-bottom: 1px solid #DCDFE6;
                                    }
                                }
                            }
                        }
                        .el-textarea{
                            margin-top: 20px;
                        }
                        .choice_item{
                            margin-top: 10px;
                            margin-bottom: 5px;
                        }
                    }
                }
            }
        }
        .marker_wrap{
            margin-left: 20px;
            width: 270px;
            border: 1px solid #eee;
            .paper_info_wrap{
                background: #ffffff;
                padding: 10px;
                border-bottom: 1px solid #eee;
                .info_wrap{
                    display: flex;
                    align-items: center;
                    span{
                        font-size: 13px;
                        color: #636e72;
                        padding-left: 10px;
                    }
                }
                .exam_stu_wrap{
                    margin-top: 5px;
                }
            }
            .question_marker_wrap{
                background: #ffffff;
                padding: 10px;
                border-bottom: 1px solid #eee;
                .question_item_wrap{
                    .marker_question_wrap{
                        .question_type_title{

                        }
                        .marker_item_wrap{
                            display: flex;
                            flex-wrap: wrap;
                            width: 250px;
                            &>p{
                                width: 40px;
                                height: 40px;
                                display: flex;
                                align-items: center;
                                justify-content: center;
                                a{
                                    margin: 5px;
                                    border: 1px solid #ccc;
                                    text-decoration: none;
                                    font-style: normal;
                                    color: #636e72;
                                    font-size: 13px;
                                    height: 30px;
                                    width: 30px;
                                    display: flex;
                                    align-items: center;
                                    justify-content: center;
                                    border-radius: 5px;
                                }
                            }
                            .answered{
                                a{
                                    background-color: #f0f9eb;
                                    border-color: #e1f3d8;
                                    color: #67c23a;
                                }
                            }
                        }
                    }
                }
            }
            .btn_wrap{
                background: #ffffff;
                padding: 10px;
                display: flex;
                align-items: center;
                justify-content: center;
                .el-button{
                    // padding: 9px 20px;
                    width: 125px;
                }
            }
        }
    }
</style>