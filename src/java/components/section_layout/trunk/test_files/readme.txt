To Reviewers:

Algorithm improvement:

We have discuss the SectionDockContainer#calculateIndex in the forum, the designer say that we should decide by ourselves.
I think we should also return -1 at last.
Because calculateIndex is used by dock(Dock, Point) and markDockGesture(Dock, Point),
In markDockGesture(Dock, Point), we should return -1 at last as the logical requirement.
But if we tried to add the first dock by dock(Dock, Point), then calculateIndex return -1, so the dock will fail.
This logic is wrong.
My solution is check whether it's the first dock in dock(Dock, Point), if it is, dock it without call calculateIndex.
And now the logic is well.


UIManager Configuration:

It's hard to configue the UIManager correctly because I'm not a expert on swing and the designer is not either.
But finally I successfully configue it. Please see TestHelper#configueUIManager.

And Note I have to change DefaultSectionHeaderUI createUI() to createUI(JComponent)
because the UIManger will invoke createUI(JComponent) to create the UI.
Otherwise it will fail.
Now it's time to submit the submission and I can't get the designer's permission.


Coverage report:

The coverage is not perfect because I can't test the private inner class directly.
You can test them through GUI.