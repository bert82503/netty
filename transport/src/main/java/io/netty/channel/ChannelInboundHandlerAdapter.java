/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package io.netty.channel;

/**
 * Abstract base class for {@link ChannelInboundHandler} implementations which provide
 * implementations of all of their methods.
 * ChannelInboundHandler实现的抽象基类，它提供了所有方法的实现。
 * (ChannelInboundHandler适配器，对象匹配器)
 *
 * <p>
 * This implementation just forward the operation to the next {@link ChannelHandler} in the
 * {@link ChannelPipeline}. Sub-classes may override a method implementation to change this.
 * 此实现只是将操作转发到ChannelPipeline中的下一个ChannelHandler。
 * (将ChannelHandlerContext接口转换成ChannelInboundHandler接口)
 * 子类可以覆盖方法实现以更改此方法。
 * </p>
 * <p>
 * Be aware that messages are not released after the {@link #channelRead(ChannelHandlerContext, Object)}
 * method returns automatically. If you are looking for a {@link ChannelInboundHandler} implementation that
 * releases the received messages automatically, please see {@link SimpleChannelInboundHandler}.
 * 请注意，在{@link #channelRead(ChannelHandlerContext, Object)}方法自动返回后，不会释放消息。
 * 如果您正在寻找自动释放收到的消息的ChannelInboundHandler实现，请参阅{@link SimpleChannelInboundHandler}。
 * </p>
 */
public class ChannelInboundHandlerAdapter extends ChannelHandlerAdapter implements ChannelInboundHandler {

    // 将ChannelHandlerContext接口转换成ChannelInboundHandler接口
    /// 对象匹配器：依赖于对象组合
    //// 当Channel状态发生改变时，将会生成对应的事件。
    /**
     * Calls {@link ChannelHandlerContext#fireChannelRegistered()} to forward
     * to the next {@link ChannelInboundHandler} in the {@link ChannelPipeline}.
     * 调用其关联的{@link ChannelHandlerContext#fireChannelRegistered()}，
     * 从而将事件转发到ChannelPipeline中的下一个ChannelInboundHandler。
     *
     * Sub-classes may override this method to change behavior.
     * 子类可以重写此方法以更改行为。
     */
    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        ctx.fireChannelRegistered();
    }

    /**
     * Calls {@link ChannelHandlerContext#fireChannelUnregistered()} to forward
     * to the next {@link ChannelInboundHandler} in the {@link ChannelPipeline}.
     * 调用其关联的{@link ChannelHandlerContext#fireChannelUnregistered()}，
     * 从而将事件转发到ChannelPipeline中的下一个ChannelInboundHandler。
     *
     * Sub-classes may override this method to change behavior.
     */
    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        ctx.fireChannelUnregistered();
    }

    /**
     * Calls {@link ChannelHandlerContext#fireChannelActive()} to forward
     * to the next {@link ChannelInboundHandler} in the {@link ChannelPipeline}.
     * 调用其关联的{@link ChannelHandlerContext#fireChannelActive()}，
     * 从而将事件转发到ChannelPipeline中的下一个ChannelInboundHandler。
     *
     * Sub-classes may override this method to change behavior.
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.fireChannelActive();
    }

    /**
     * Calls {@link ChannelHandlerContext#fireChannelInactive()} to forward
     * to the next {@link ChannelInboundHandler} in the {@link ChannelPipeline}.
     * 调用其关联的{@link ChannelHandlerContext#fireChannelInactive()}，
     * 从而将事件转发到ChannelPipeline中的下一个ChannelInboundHandler。
     *
     * Sub-classes may override this method to change behavior.
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        ctx.fireChannelInactive();
    }


    // 读取入站数据
    /**
     * Calls {@link ChannelHandlerContext#fireChannelRead(Object)} to forward
     * to the next {@link ChannelInboundHandler} in the {@link ChannelPipeline}.
     * 调用其关联的{@link ChannelHandlerContext#fireChannelRead(Object)}，
     * 从而将事件转发到ChannelPipeline中的下一个ChannelInboundHandler。
     *
     * Sub-classes may override this method to change behavior.
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ctx.fireChannelRead(msg);
    }

    /**
     * Calls {@link ChannelHandlerContext#fireChannelReadComplete()} to forward
     * to the next {@link ChannelInboundHandler} in the {@link ChannelPipeline}.
     * 调用其关联的{@link ChannelHandlerContext#fireChannelReadComplete()}，
     * 从而将事件转发到ChannelPipeline中的下一个ChannelInboundHandler。
     *
     * Sub-classes may override this method to change behavior.
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.fireChannelReadComplete();
    }

    /**
     * Calls {@link ChannelHandlerContext#fireUserEventTriggered(Object)} to forward
     * to the next {@link ChannelInboundHandler} in the {@link ChannelPipeline}.
     * 调用其关联的{@link ChannelHandlerContext#fireUserEventTriggered(Object)}，
     * 从而将事件转发到ChannelPipeline中的下一个ChannelInboundHandler。
     *
     * Sub-classes may override this method to change behavior.
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        ctx.fireUserEventTriggered(evt);
    }

    /**
     * Calls {@link ChannelHandlerContext#fireChannelWritabilityChanged()} to forward
     * to the next {@link ChannelInboundHandler} in the {@link ChannelPipeline}.
     * 调用其关联的{@link ChannelHandlerContext#fireChannelWritabilityChanged()}，
     * 从而将事件转发到ChannelPipeline中的下一个ChannelInboundHandler。
     *
     * Sub-classes may override this method to change behavior.
     */
    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        ctx.fireChannelWritabilityChanged();
    }

    /**
     * Calls {@link ChannelHandlerContext#fireExceptionCaught(Throwable)} to forward
     * to the next {@link ChannelHandler} in the {@link ChannelPipeline}.
     * 调用其关联的{@link ChannelHandlerContext#fireExceptionCaught(Throwable)}，
     * 从而将事件转发到ChannelPipeline中的下一个ChannelInboundHandler。
     *
     * Sub-classes may override this method to change behavior.
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        ctx.fireExceptionCaught(cause);
    }
}
