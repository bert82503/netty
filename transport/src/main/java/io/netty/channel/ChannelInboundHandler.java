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
 * {@link ChannelHandler} which adds callbacks for state changes. This allows the user
 * to hook in to state changes easily.
 * 它是一种ChannelHandler，为状态更改添加回调。(处理入站数据以及各种状态变化)
 * 这允许用户容易地接入状态变化。
 */
public interface ChannelInboundHandler extends ChannelHandler {

    // Channel的生命周期
    /// Channel的生命周期状态
    /// Channel的状态模型(Registered -> Active -> Inactive -> Unregistered)

    /// ChannelInboundHandler的生命周期方法
    /**
     * The {@link Channel} of the {@link ChannelHandlerContext} was registered with its {@link EventLoop}.
     * Channel已经注册到它的EventLoop。(能够处理I/O)
     */
    void channelRegistered(ChannelHandlerContext ctx) throws Exception;

    /**
     * The {@link Channel} of the {@link ChannelHandlerContext} was unregistered from its {@link EventLoop}.
     * Channel从它的EventLoop注销。(无法处理任何I/O)
     */
    void channelUnregistered(ChannelHandlerContext ctx) throws Exception;

    /**
     * The {@link Channel} of the {@link ChannelHandlerContext} is now active.
     * Channel现在处于活动状态。(已经连接/绑定并且已经就绪)
     * (已经连接到它的远程节点，可以接收和发送数据)
     */
    void channelActive(ChannelHandlerContext ctx) throws Exception;

    /**
     * The {@link Channel} of the {@link ChannelHandlerContext} was registered is now inactive and reached its
     * end of lifetime.
     * Channel离开活动状态，并且达到生命的终点。(不再连接它的远程节点)
     * (没有连接到远程节点)
     */
    void channelInactive(ChannelHandlerContext ctx) throws Exception;


    /**
     * Invoked when the current {@link Channel} has read a message from the peer.
     * 当前Channel从对等方读取消息时被调用。
     */
    void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception;

    /**
     * Invoked when the last message read by the current read operation has been consumed by
     * {@link #channelRead(ChannelHandlerContext, Object)}.  If {@link ChannelOption#AUTO_READ} is off, no further
     * attempt to read an inbound data from the current {@link Channel} will be made until
     * {@link ChannelHandlerContext#read()} is called.
     * 当前读取操作读取到的最后一条消息被{@link #channelRead(ChannelHandlerContext, Object)}方法消费后被调用。
     * (当Channel上的一个读操作完成时被调用)
     */
    void channelReadComplete(ChannelHandlerContext ctx) throws Exception;

    /**
     * Gets called if an user event was triggered.
     */
    void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception;

    /**
     * Gets called once the writable state of a {@link Channel} changed. You can check the state with
     * {@link Channel#isWritable()}.
     * 当Channel的可写状态发生改变时被调用。
     */
    void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception;

    /**
     * Gets called if a {@link Throwable} was thrown.
     */
    @Override
    @SuppressWarnings("deprecated")
    void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception;
}
