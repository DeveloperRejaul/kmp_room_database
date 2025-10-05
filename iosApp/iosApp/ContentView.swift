import UIKit
import SwiftUI
import ComposeApp


struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {

        // provide room database
        let db = DatabaseProvider.shared.provideDatabase(builder: Database_iosKt.getDatabaseBuilder())
        return MainViewControllerKt.MainViewController(database: db)
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct ContentView: View {
    var body: some View {
        ComposeView()
            .ignoresSafeArea()
    }
}



