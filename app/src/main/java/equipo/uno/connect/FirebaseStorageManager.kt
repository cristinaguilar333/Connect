package equipo.uno.connect

import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.util.Log
import com.google.firebase.storage.FirebaseStorage

class FirebaseStorageManager {
    private val TAG="FirebaseStorageManager"

    private val mStorageRef= FirebaseStorage.getInstance().reference
    private lateinit var mProgressDialog: ProgressDialog

    fun uploadImage(mContext: Context, imageUri: Uri){
        mProgressDialog= ProgressDialog(mContext)
        mProgressDialog.setMessage("Please wait, image being uploading...")
        val uploadTask=mStorageRef.child("user/profilePic.png").putFile(imageUri)
        uploadTask.addOnSuccessListener {
            Log.e(TAG,"Image Upload Succesfuly")
        }.addOnFailureListener{
            Log.e(TAG,"Image Upload Failed ${it.printStackTrace()}")
        }
    }
}