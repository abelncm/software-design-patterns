# Adapter Pattern

The Adapter pattern is a structural design pattern that allows objects with incompatible interfaces to collaborate. It acts as a bridge between two incompatible interfaces by converting the interface of a class (Adaptee) into another interface that a client expects (Target).

## Purpose

*   **Convert Interface:** Convert the interface of a class into another interface clients expect.
*   **Enable Collaboration:** Allow classes to work together that couldn't otherwise because of incompatible interfaces.
*   **Wrap Existing Class:** Wrap an existing class with a new interface without modifying the original class.

## Use Cases

*   **Using Existing Classes:** When you want to use an existing class (Adaptee), but its interface does not match the interface your client code requires (Target).
*   **Reusable Class with Unforeseen Interfaces:** When you are creating a reusable class that needs to cooperate with other unrelated or unforeseen classes that may not have compatible interfaces.
*   **Object Adapter for Multiple Subclasses:** When you need to use several existing subclasses of an Adaptee, but it's impractical to adapt their interface by subclassing every one. An object adapter can adapt the interface of its parent Adaptee class and thus work with all its subclasses.
*   **Third-Party Library Integration:** When integrating a third-party library that has an interface different from what your application uses.
*   **Legacy Code Integration:** Making new components compatible with older, legacy systems that have fixed interfaces.

## Pros

*   **Interoperability:** Allows two or more previously incompatible objects to interact by conforming to a common Target interface.
*   **Reusability of Existing Code:** Improves reusability of older or third-party functionality by adapting it to modern interfaces.
*   **Single Responsibility Principle:** The adapter class handles the responsibility of interface conversion, keeping the client and adaptee code focused on their respective tasks.
*   **Decoupling:** Decouples the client from the concrete implementation of the Adaptee. The client only depends on the Target interface.

## Cons

*   **Increased Complexity:** Introduces an additional layer of indirection (the adapter class itself), which can increase the overall complexity of the system if many adapters are needed.
*   **Implementation Effort:** Adapters can sometimes be difficult or cumbersome to implement if the Target and Adaptee interfaces are vastly different or require complex data transformations.
*   **Potential for "Adapter Hell":** If too many parts of a system are connected via adapters, it can become hard to understand the flow of data and control.

## Java Example Explanation

The Java example in this directory demonstrates the Adapter pattern for a media player application. The `AudioPlayer` (Client) wants to use a `MediaPlayer` (Target) interface to play various audio formats. While it can play "mp3" natively, it needs an adapter to play "vlc" and "mp4" formats, which are handled by `AdvancedMediaPlayer` (Adaptee) implementations.

*   **`MediaPlayer.java` (Target Interface):**
    *   Defines the interface expected by the client (`AudioPlayer`).
    *   Declares the `play(String audioType, String fileName)` method.

*   **`AdvancedMediaPlayer.java` (Adaptee Interface):**
    *   Represents the interface of the classes that need adapting.
    *   Declares methods specific to advanced formats like `playVlc(String fileName)` and `playMp4(String fileName)`.

*   **`VlcPlayer.java`, `Mp4Player.java` (Concrete Adaptees):**
    *   Implement the `AdvancedMediaPlayer` interface for specific audio formats (VLC and MP4).
    *   `VlcPlayer` implements `playVlc()`.
    *   `Mp4Player` implements `playMp4()`.

*   **`MediaAdapter.java` (Adapter Class):**
    *   Implements the `MediaPlayer` (Target) interface.
    *   Holds an instance of an `AdvancedMediaPlayer` (Adaptee).
    *   The constructor `MediaAdapter(String audioType)` initializes the appropriate `AdvancedMediaPlayer` (e.g., `VlcPlayer` if `audioType` is "vlc").
    *   The `play(String audioType, String fileName)` method translates the call:
        *   If this adapter instance is for "vlc" and `audioType` is "vlc", it calls `advancedMusicPlayer.playVlc(fileName)`.
        *   If this adapter instance is for "mp4" and `audioType` is "mp4", it calls `advancedMusicPlayer.playMp4(fileName)`.
        *   Otherwise, it indicates that the adapter instance cannot handle the request.

*   **`AudioPlayer.java` (Client Class):**
    *   Implements the `MediaPlayer` interface for simplicity in this example (it could also just use a `MediaPlayer` instance).
    *   It can play "mp3" files directly.
    *   For "vlc" or "mp4" types, it instantiates `MediaAdapter` with the specific audio type and then calls the adapter's `play` method. This delegates the playing of these advanced formats to the adapter, which then uses the adaptee.

*   **`AdapterDemo.java` (Demo Class):**
    *   Showcases the functionality:
        1.  An `AudioPlayer` plays an "mp3" file directly.
        2.  The `AudioPlayer` then plays "vlc" and "mp4" files, transparently using the `MediaAdapter`.
        3.  Demonstrates direct usage of `MediaAdapter` instances to show how they are specific to the type they were created for.

This example illustrates how the `MediaAdapter` allows the `AudioPlayer` to work with `VlcPlayer` and `Mp4Player` even though they have different interfaces, by adapting them to the `MediaPlayer` interface that `AudioPlayer` expects.
