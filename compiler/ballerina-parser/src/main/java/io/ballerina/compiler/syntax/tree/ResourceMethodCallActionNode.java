/*
 *  Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package io.ballerina.compiler.syntax.tree;

import io.ballerina.compiler.internal.parser.tree.STNode;

import java.util.Objects;
import java.util.Optional;

/**
 * This is a generated syntax tree node.
 *
 * @since 2.0.0
 */
public class ResourceMethodCallActionNode extends ActionNode {

    public ResourceMethodCallActionNode(STNode internalNode, int position, NonTerminalNode parent) {
        super(internalNode, position, parent);
    }

    public ExpressionNode expression() {
        return childInBucket(0);
    }

    public Token resourceMethodCallToken() {
        return childInBucket(1);
    }

    public NodeList<Node> resourceAccessPath() {
        return new NodeList<>(childInBucket(2));
    }

    public Optional<Token> dotToken() {
        return optionalChildInBucket(3);
    }

    public Optional<SimpleNameReferenceNode> methodName() {
        return optionalChildInBucket(4);
    }

    public Optional<ParenthesizedArgList> arguments() {
        return optionalChildInBucket(5);
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public <T> T apply(NodeTransformer<T> visitor) {
        return visitor.transform(this);
    }

    @Override
    protected String[] childNames() {
        return new String[]{
                "expression",
                "resourceMethodCallToken",
                "resourceAccessPath",
                "dotToken",
                "methodName",
                "arguments"};
    }

    public ResourceMethodCallActionNode modify(
            ExpressionNode expression,
            Token resourceMethodCallToken,
            NodeList<Node> resourceAccessPath,
            Token dotToken,
            SimpleNameReferenceNode methodName,
            ParenthesizedArgList arguments) {
        if (checkForReferenceEquality(
                expression,
                resourceMethodCallToken,
                resourceAccessPath.underlyingListNode(),
                dotToken,
                methodName,
                arguments)) {
            return this;
        }

        return NodeFactory.createResourceMethodCallActionNode(
                expression,
                resourceMethodCallToken,
                resourceAccessPath,
                dotToken,
                methodName,
                arguments);
    }

    public ResourceMethodCallActionNodeModifier modify() {
        return new ResourceMethodCallActionNodeModifier(this);
    }

    /**
     * This is a generated tree node modifier utility.
     *
     * @since 2.0.0
     */
    public static class ResourceMethodCallActionNodeModifier {
        private final ResourceMethodCallActionNode oldNode;
        private ExpressionNode expression;
        private Token resourceMethodCallToken;
        private NodeList<Node> resourceAccessPath;
        private Token dotToken;
        private SimpleNameReferenceNode methodName;
        private ParenthesizedArgList arguments;

        public ResourceMethodCallActionNodeModifier(ResourceMethodCallActionNode oldNode) {
            this.oldNode = oldNode;
            this.expression = oldNode.expression();
            this.resourceMethodCallToken = oldNode.resourceMethodCallToken();
            this.resourceAccessPath = oldNode.resourceAccessPath();
            this.dotToken = oldNode.dotToken().orElse(null);
            this.methodName = oldNode.methodName().orElse(null);
            this.arguments = oldNode.arguments().orElse(null);
        }

        public ResourceMethodCallActionNodeModifier withExpression(
                ExpressionNode expression) {
            Objects.requireNonNull(expression, "expression must not be null");
            this.expression = expression;
            return this;
        }

        public ResourceMethodCallActionNodeModifier withResourceMethodCallToken(
                Token resourceMethodCallToken) {
            Objects.requireNonNull(resourceMethodCallToken, "resourceMethodCallToken must not be null");
            this.resourceMethodCallToken = resourceMethodCallToken;
            return this;
        }

        public ResourceMethodCallActionNodeModifier withResourceAccessPath(
                NodeList<Node> resourceAccessPath) {
            Objects.requireNonNull(resourceAccessPath, "resourceAccessPath must not be null");
            this.resourceAccessPath = resourceAccessPath;
            return this;
        }

        public ResourceMethodCallActionNodeModifier withDotToken(
                Token dotToken) {
            this.dotToken = dotToken;
            return this;
        }

        public ResourceMethodCallActionNodeModifier withMethodName(
                SimpleNameReferenceNode methodName) {
            this.methodName = methodName;
            return this;
        }

        public ResourceMethodCallActionNodeModifier withArguments(
                ParenthesizedArgList arguments) {
            this.arguments = arguments;
            return this;
        }

        public ResourceMethodCallActionNode apply() {
            return oldNode.modify(
                    expression,
                    resourceMethodCallToken,
                    resourceAccessPath,
                    dotToken,
                    methodName,
                    arguments);
        }
    }
}
