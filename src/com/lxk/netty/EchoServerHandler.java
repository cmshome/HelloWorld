package com.lxk.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.io.UnsupportedEncodingException;

/**
 * @author kirin on 19/7/9
 */
public class EchoServerHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws  Exception{
        System.out.println("channel registered  " + ctx.channel().remoteAddress().toString());
        super.channelRegistered(ctx);
//        System.out.println(ctx.channel().localAddress().toString() + " 通道已激活！");
        String k = "001416900000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000009<root> <return_data> <this_acct_date>20221220</this_acct_date> <mutp_pag_qury_piec_num>0000</mutp_pag_qury_piec_num> <tmnl_num_leng_14>INTERNET</tmnl_num_leng_14> <info_typ>E</info_typ> <tran_cod_cntn_aply_cod>0200611</tran_cod_cntn_aply_cod> <mutp_qury_prsd_cnt>000000000</mutp_qury_prsd_cnt> <intor_tran_cod>0200611</intor_tran_cod> <mesg_id>PMRA888</mesg_id> <retn_info_desc>获取交易网点失败!&amp;1,&amp;2,&amp;3</retn_info_desc> <intor_tran_jnal_num>GCMS202212201017530003476w8j83tngd2m</intor_tran_jnal_num> <mesg_typ>0110</mesg_typ> <tran_log_num>SC010128417826</tran_log_num> <rspn_cod>30</rspn_cod> <tran_mesg_cycl_cnt>00</tran_mesg_cycl_cnt> <tran_call_sequ_num>000</tran_call_sequ_num> <bank_num>001</bank_num> <mutp_pag_qury_rcrd_sum>0000</mutp_pag_qury_rcrd_sum> <nesb_jnal_num>032312399070</nesb_jnal_num> </return_data> <transaction_ouput_data> <mesg_data_list> <mesg_data> <mesg_id>PMRA888</mesg_id> <mesg_txt>获取交易网点失败!&amp;1,&amp;2,&amp;3</mesg_txt> </mesg_data> </mesg_data_list> <mesg_cntt_cnt>01</mesg_cntt_cnt> <fee_data_out_area_cnt>00</fee_data_out_area_cnt> <recp_data_cnt>00</recp_data_cnt> </transaction_ouput_data> <control_area> <strk_balc_flg>N</strk_balc_flg> <mutp_pag_qury_flg>N</mutp_pag_qury_flg> </control_area> </root> ";
        ctx.writeAndFlush(Unpooled.copiedBuffer(k, CharsetUtil.UTF_8)).addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) {
                if(!future.isSuccess()) {
                    System.out.println("---------------");
                    future.channel().close();
                }else {
//                    System.out.println("*********");
                }
            }
        });
    }

    /*
        * channelAction
        *
        * channel 通道 action 活跃的
        *
        * 当客户端主动链接服务端的链接后，这个通道就是活跃的了。也就是客户端与服务端建立了通信通道并且可以传输数据
        *
        */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

    }

    /*
     * channelInactive
     *
     * channel 通道 Inactive 不活跃的
     *
     * 当客户端主动断开服务端的链接后，这个通道就是不活跃的。也就是说客户端与服务端的关闭了通信通道并且不可以传输数据
     *
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().localAddress().toString() + " 通道不活跃！");
        // 关闭流

    }

    /**
     *  此处用来处理收到的数据中含有中文的时  出现乱码的问题
     * @return
     */
    private String getMessage(ByteBuf buf) {
        byte[] con = new byte[buf.readableBytes()];
        buf.readBytes(con);
        try {
            return new String(con, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 功能：读取服务器发送过来的信息
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 第一种：接收字符串时的处理
        ByteBuf buf = (ByteBuf) msg;
        String rev = getMessage(buf);
        System.out.println("客户端收到服务器数据:" + rev);

    }

    /**
     * 功能：读取完毕客户端发送过来的数据之后的操作
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//        System.out.println("服务端接收数据完毕..");
        // 第一种方法：写一个空的buf，并刷新写出区域。完成后关闭sock channel连接。
        //ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
        // ctx.flush();
        // ctx.flush(); //
        // 第二种方法：在client端关闭channel连接，这样的话，会触发两次channelReadComplete方法。
        // ctx.flush().close().sync(); // 第三种：改成这种写法也可以，但是这中写法，没有第一种方法的好。
    }

    /**
     * 功能：服务端发生异常的操作
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
        System.out.println("异常信息：\r\n" + cause.getMessage());
    }

}
