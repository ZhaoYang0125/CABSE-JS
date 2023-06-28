<template>
<div>
    <div>
        <h2>微信扫码支付</h2>
        <br></br>
        <br></br>
    </div>
    <div align="center" id="qrcode">
    </div>
    <div>
        <br></br>
        <br></br>
        <el-button @click="goBack">返回</el-button>
    </div>

</div>

</template>

<script>
    import QRCode from 'qrcodejs2'
    export default {
        name: "Pay",
        data() {
            return {
                link: "https://cet.neea.edu.cn/",
            };
        },
        created() {
            this.createQrcode();
        },

        beforeMount() {
            this.payOrder();
        },

        methods: {
            // 信息写入二维码
            payOrder() {
                this.innerVisible = true;
                this.qrcode = this.link;
                this.$nextTick(() => {
                    this.createQrcode();
                });
            },

            // 生成二维码
            createQrcode() {
                this.qr = new QRCode("qrcode", {
                    width: 200, //宽度
                    height: 200,            // 高度
                    text: this.qrcode,      // 二维码内容
                    render: "table",        // 设置渲染方式（有两种方式 table和canvas，默认是canvas）
                });
            },

            goBack() {
                this.$router.go(-1);
            },
        }
    }
</script>

<style scoped>

</style>
