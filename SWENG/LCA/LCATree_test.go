package main


import (
	"testing"
	"github.com/stretchr/testify/assert"
)

func TestNewNode(t *testing.T){

	poggers := newNode(10, nil, nil)
	cheeky := newNode(5, nil, poggers)
	assert.Equal(t, poggers.val, 10, "The value of poggers node is 10")
	assert.Equal(t, cheeky.right, poggers, "The right child of node cheeky is poggers")

}

func TestLCA(t *testing.T){

	var fakeNode *Node = nil

	root := newNode(100, nil, nil)
	root.left = newNode(50,nil,nil)
	root.right = newNode(150,nil,nil)
	root.left.left = newNode(20,nil,nil)
	root.left.left.left = newNode(10,nil,nil)
	root.left.left.right = newNode(30,nil,nil)
	root.left.right = newNode(80,nil,nil)
	root.right.left = newNode(110, nil, nil)
	root.right.right = newNode(200, nil,nil)


	answer1 := LCA(root, 10, 30)
	assert.Equal(t, 20, answer1.val, "20 should be the LCA of 10 and 30")
	answer2 := LCA(root, 200, 20)
	assert.Equal(t, 100, answer2.val, "100 should be the LCA of 200 and 20")
	answer3 := LCA(fakeNode, 40, 90)
	assert.Equal(t, -999999, answer3.val, "nil should be the LCA of 40 and 90, because of the nil root")

}

func TestSearch(t *testing.T){

	var fakeNode *Node = nil

	root := newNode(10, nil, nil)
	root.left = newNode(5, nil,nil)
	root.right = newNode(15, nil,nil)
	root.left.left = newNode(2, nil,nil)
	root.left.right = newNode(4,nil,nil)
	root.right.left = newNode(12, nil,nil)
	root.right.right = newNode(18, nil,nil)

	answer1 := search(root, 4)
	assert.Equal(t, true, answer1, "Node 4 exists within the tree")

	answer2 := search(root, 12)
	assert.Equal(t, true, answer2, "Node 12 exists within the tree")

	answer3 := search(root, 10)
	assert.Equal(t, true, answer3, "Node 10 exists as the root")

	answer4 := search(root, 19)
	assert.Equal(t, false, answer4, "Node 19 does not exist within the tree")

	answer5 := search(fakeNode, 10)
	assert.Equal(t, false, answer5, "Node 10 does not exist in the tree where fakeNode is the root")
}
