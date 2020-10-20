package main

import (
	"fmt"
)

type Node struct{
	val int
	left *Node
	right *Node
}


func newNode(val int, left *Node, right *Node) *Node{
	return &Node{
		val: val,
		left : left,
		right : right,
	}
}

func LCA(root *Node, val1 int, val2 int) *Node{
	if root == nil {
		return newNode(-99999, nil,nil)
	}
	if search(root, val1) == false{
		return newNode(-99999, nil,nil)
	}
	if search(root, val2) == false{
		return newNode(-99999, nil,nil)
	}
	if search(root, val1) == true && search(root, val2) == true{
		return LowestCommonAncestor(root, val1, val2)
	}

	return nil
}

func search(root *Node, key int) bool{
	if root == nil{
		return false
	}
	if key < root.val {
		search(root.left, key)
	}
	if key > root.val{
		search(root.right, key)
	}
	return true
}

func LowestCommonAncestor(root *Node, val1 int, val2 int) *Node{
	if root == nil {
		return nil
	}

	if val1 > root.val && val2 > root.val{
		return LowestCommonAncestor(root.right, val1, val2)
	}

	if val1 < root.val && val2 < root.val {
		return LowestCommonAncestor(root.left, val1, val2)
	}

	return root
}

func main(){

	root := Node{100, nil, nil}
	root.left = &Node{50, nil, nil}
	root.right = &Node{150, nil, nil}
	root.left.left = &Node{20, nil, nil}
	root.left.left.left = &Node{10, nil, nil}
	root.left.left.right = &Node{30, nil, nil}
	root.left.right = &Node{80, nil, nil}
	root.right.left = &Node{110, nil, nil}
	root.right.right = &Node{200, nil, nil}

	var result = LowestCommonAncestor(&root, 10, 80)
	fmt.Println("LAC of 10 and 80 is", result.val)

	var result2 = LowestCommonAncestor(&root, 30, 200)
	fmt.Println("LAC of 30 and 200 is", result2.val)

	var result3 = LowestCommonAncestor(&root, 10, 30)
	fmt.Println("LCA of 10 and 30 is", result3.val)

}

