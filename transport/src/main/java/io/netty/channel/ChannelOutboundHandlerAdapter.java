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

import java.net.SocketAddress;

/**
 * Skeleton implementation of a {@link ChannelOutboundHandler}. This implementation just forwards each method call via
 * the {@link ChannelHandlerContext}.
 * ChannelOutboundHandler的基本实现。本实现只是通过ChannelHandlerContext转发每个方法调用。
 * (ChannelOutboundHandler适配器，对象匹配器)
 */
public class ChannelOutboundHandlerAdapter extends ChannelHandlerAdapter implements ChannelOutboundHandler {

    // 将ChannelHandlerContext接口转换成ChannelOutboundHandler接口
    /**
     * Calls {@link ChannelHandlerContext#bind(SocketAddress, ChannelPromise)} to forward
     * to the next {@link ChannelOutboundHandler} in the {@link ChannelPipeline}.
     * 调用其关联的{@link ChannelHandlerContext#bind(SocketAddress, ChannelPromise)}，
     * 从而将事件转发到ChannelPipeline中的下一个ChannelOutboundHandler。
     *
     * Sub-classes may override this method to change behavior.
     * 子类可以重写此方法以更改行为。
     */
    @Override
    public void bind(ChannelHandlerContext ctx, SocketAddress localAddress,
            ChannelPromise promise) throws Exception {
        ctx.bind(localAddress, promise);
    }

    /**
     * Calls {@link ChannelHandlerContext#connect(SocketAddress, SocketAddress, ChannelPromise)} to forward
     * to the next {@link ChannelOutboundHandler} in the {@link ChannelPipeline}.
     * 调用其关联的{@link ChannelHandlerContext#connect(SocketAddress, SocketAddress, ChannelPromise)}，
     * 从而将事件转发到ChannelPipeline中的下一个ChannelOutboundHandler。
     *
     * Sub-classes may override this method to change behavior.
     */
    @Override
    public void connect(ChannelHandlerContext ctx, SocketAddress remoteAddress,
            SocketAddress localAddress, ChannelPromise promise) throws Exception {
        ctx.connect(remoteAddress, localAddress, promise);
    }

    /**
     * Calls {@link ChannelHandlerContext#disconnect(ChannelPromise)} to forward
     * to the next {@link ChannelOutboundHandler} in the {@link ChannelPipeline}.
     * 调用其关联的{@link ChannelHandlerContext#disconnect(ChannelPromise)}，
     * 从而将事件转发到ChannelPipeline中的下一个ChannelOutboundHandler。
     *
     * Sub-classes may override this method to change behavior.
     */
    @Override
    public void disconnect(ChannelHandlerContext ctx, ChannelPromise promise)
            throws Exception {
        ctx.disconnect(promise);
    }

    /**
     * Calls {@link ChannelHandlerContext#close(ChannelPromise)} to forward
     * to the next {@link ChannelOutboundHandler} in the {@link ChannelPipeline}.
     * 调用其关联的{@link ChannelHandlerContext#close(ChannelPromise)}，
     * 从而将事件转发到ChannelPipeline中的下一个ChannelOutboundHandler。
     *
     * Sub-classes may override this method to change behavior.
     */
    @Override
    public void close(ChannelHandlerContext ctx, ChannelPromise promise)
            throws Exception {
        ctx.close(promise);
    }

    /**
     * Calls {@link ChannelHandlerContext#deregister(ChannelPromise)} to forward
     * to the next {@link ChannelOutboundHandler} in the {@link ChannelPipeline}.
     * 调用其关联的{@link ChannelHandlerContext#deregister(ChannelPromise)}，
     * 从而将事件转发到ChannelPipeline中的下一个ChannelOutboundHandler。
     *
     * Sub-classes may override this method to change behavior.
     */
    @Override
    public void deregister(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
        ctx.deregister(promise);
    }


    // 处理出站数据
    /**
     * Calls {@link ChannelHandlerContext#read()} to forward
     * to the next {@link ChannelOutboundHandler} in the {@link ChannelPipeline}.
     * 调用其关联的{@link ChannelHandlerContext#read()}，
     * 从而将事件转发到ChannelPipeline中的下一个ChannelOutboundHandler。
     *
     * Sub-classes may override this method to change behavior.
     */
    @Override
    public void read(ChannelHandlerContext ctx) throws Exception {
        ctx.read();
    }

    /**
     * Calls {@link ChannelHandlerContext#write(Object, ChannelPromise)} to forward
     * to the next {@link ChannelOutboundHandler} in the {@link ChannelPipeline}.
     * 调用其关联的{@link ChannelHandlerContext#write(Object, ChannelPromise)}，
     * 从而将事件转发到ChannelPipeline中的下一个ChannelOutboundHandler。
     *
     * Sub-classes may override this method to change behavior.
     */
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        ctx.write(msg, promise);
    }

    /**
     * Calls {@link ChannelHandlerContext#flush()} to forward
     * to the next {@link ChannelOutboundHandler} in the {@link ChannelPipeline}.
     * 调用其关联的{@link ChannelHandlerContext#flush()}，
     * 从而将事件转发到ChannelPipeline中的下一个ChannelOutboundHandler。
     *
     * Sub-classes may override this method to change behavior.
     */
    @Override
    public void flush(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
}
